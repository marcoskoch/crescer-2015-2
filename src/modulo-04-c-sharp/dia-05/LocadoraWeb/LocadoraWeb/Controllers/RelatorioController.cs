using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LocadoraWeb.Controllers
{
    public class RelatorioController : Controller
    {
        // GET: Relatorio
        public ActionResult JogosDisponiveis()
        {
            return View();
        }
    }
}