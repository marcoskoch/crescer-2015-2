﻿using EF;
using Locadora.Dominio.Repositorio;
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
            IUsuarioRepositorio jogoRepositorio = new UsuarioRepositorio();
            //TODO: validar usuario
            //var salt = System.Text.Encoding.UTF8.GetBytes(usuario);
            //var password = System.Text.Encoding.UTF8.GetBytes(senha);
            //var hmacMD5 = new HMACMD5(salt);
            //var saltedHash = hmacMD5.ComputeHash(password);

            //string asdasd = saltedHash;

            var usuarioLogin = jogoRepositorio.BuscarPorEmail(usuario);
            var permissoesLogin = usuarioLogin.Permissoes.Select(p => p.Nome).ToArray();

            if (usuario == usuarioLogin.Email && senha == usuarioLogin.Senha)
            {
                var usuarioLogadoModel = new UsuarioLogado(usuarioLogin.Email, permissoesLogin);

                FormsAuthentication.SetAuthCookie(usuario, true);
                Session["USUARIO_LOGADO"] = usuarioLogadoModel;
            }

            return RedirectToAction("Index", "Home");
        }
    }
}