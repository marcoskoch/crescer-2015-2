using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
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
            //TODO: validar usuario
            //var salt = System.Text.Encoding.UTF8.GetBytes(usuario);
            //var password = System.Text.Encoding.UTF8.GetBytes(senha);
            //var hmacMD5 = new HMACMD5(salt);
            //var saltedHash = hmacMD5.ComputeHash(password);

            //string asdasd = saltedHash;

            if (usuario == "didi" && senha == "die")
            {
                var usuarioLogadoModel = new UsuarioLogado("didi", new string[] { "MASTER" });

                FormsAuthentication.SetAuthCookie(usuario, true);
                Session["USUARIO_LOGADO"] = usuarioLogadoModel;
            }

            return RedirectToAction("Index", "Home");
        }
    }
}