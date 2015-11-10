using EF;
using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class BaseController : Controller
    {
        public IJogoRepositorio CriarJogoRepositorio()
        {
            return new JogoRepositorio();
        }
    }
}