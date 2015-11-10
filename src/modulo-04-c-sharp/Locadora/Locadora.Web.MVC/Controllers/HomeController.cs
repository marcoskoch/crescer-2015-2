using Locadora.Web.MVC.Seguranca.Filters;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class HomeController : Controller
    {
        [Autorizador(Roles = "MASTER")]
        public ActionResult Index()
        {
            ViewBag.NomeUsuario = Session["NOME_USUARIO"];
            return View();
        }
    }
}