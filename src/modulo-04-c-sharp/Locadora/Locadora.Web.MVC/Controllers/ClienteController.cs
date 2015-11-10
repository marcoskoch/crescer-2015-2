using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class ClienteController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Manter(int? id)
        {
            if (id.HasValue)
            {
                //Busca cliente do banco
                var model = new ClienteModel()
                {
                    Id = 5,
                    Nome = "Didi must die",
                    Email = "didi@didi.com",
                    EmailConfimacao = "didi@didi.com",
                    Idade = 80
                };

                return View(model);
            }
            else
            {
                return View();
            }
        }

        public ActionResult Salvar(JogoModel model)
        {
            ModelState.AddModelError("Nome", "Nome já existe no banco de dados!");
            ModelState.AddModelError("", "Tem coisa errada aí...");

            if (ModelState.IsValid)
            {
                //salvar no banco
                TempData["Mensagem"] = "Cliente salvo com sucesso!";

                return RedirectToAction("Index", "Cliente");
            }
            else
            {
                return View("Manter", model);
            }
        }
    }
}