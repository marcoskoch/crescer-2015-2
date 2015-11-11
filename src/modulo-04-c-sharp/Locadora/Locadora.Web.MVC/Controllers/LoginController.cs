using EF;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca.Filters;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace Locadora.Web.MVC.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Login(string usuario, string senha)
        {
            IUsuarioRepositorio jogoRepositorio = new UsuarioRepositorio();
            SenhaCriptografada seguraca = new SenhaCriptografada();
            //TODO: validar usuario


            var senhaCriptografada = seguraca.SaltedHash(usuario, senha);
            var usuarioLogin = jogoRepositorio.BuscarPorEmail(usuario);
            var permissoesLogin = usuarioLogin.Permissoes.Select(p => p.Nome).ToArray();

            if (usuario == usuarioLogin.Email && senhaCriptografada == usuarioLogin.Senha)
            {
                var usuarioLogadoModel = new UsuarioLogado(usuarioLogin.Email, permissoesLogin);

                FormsAuthentication.SetAuthCookie(usuario, true);
                Session["USUARIO_LOGADO"] = usuarioLogadoModel;
            }

            return RedirectToAction("Index", "Home");
        }
    }
}