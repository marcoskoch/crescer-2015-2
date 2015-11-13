using EF;
using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca.Filters;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class RelatorioController : BaseController
    {
        IJogoRepositorio jogoRepositorio = new JogoRepositorio();

        [Autorizador(Roles = "OPERADOR")]
        public ActionResult JogosFiltradosPorId(int id)
        {
            return View();
        }

        [Autorizador(Roles = "OPERADOR")]
        public ActionResult JogosDisponiveis(string nome)
        {
            IList<Jogo> jogosEncontrados = null;

            if (string.IsNullOrEmpty(nome))
            {
                jogosEncontrados = jogoRepositorio.BuscarTodos();
            }
            else
            {
                jogosEncontrados = jogoRepositorio.BuscarPorNome(nome);
            }

            RelatorioJogosDisponiveisModel model = new RelatorioJogosDisponiveisModel(jogosEncontrados);

            return View(model);
        }

        public JsonResult JogosAutocomplete(string term)
        {
            IList<Jogo> jogosEncontrados = null;
            IJogoRepositorio jogoRepositorio = FabricaDeModulos.CriarJogoRepositorio();

            if (string.IsNullOrEmpty(term))
            {
                jogosEncontrados = jogoRepositorio.BuscarTodos();
            }
            else
            {
                jogosEncontrados = jogoRepositorio.BuscarPorNome(term);
            }

            var json = jogosEncontrados.Select(x => new { label = x.Nome });

            return Json(json, JsonRequestBehavior.AllowGet);
        }
    }
}