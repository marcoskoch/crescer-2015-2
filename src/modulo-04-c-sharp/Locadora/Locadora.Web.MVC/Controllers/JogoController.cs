using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : Controller
    {
        private IJogoRepositorio jogoRepositorio = new Repositorio.ADO.JogoRepositorio();

        public ActionResult DetalhesDoJogo(int id)
        {
            var jogo = jogoRepositorio.BuscarPorId(id);

            JogoModel model = new JogoModel()
            {
                Id = jogo.Id,
                Nome = jogo.Nome,
                Descricao = jogo.Descricao,
                Preco = jogo.Preco,
                Categoria = jogo.Categoria.ToString(),
                Selo = jogo.Selo.ToString()
            };

            return View(model);
        }
    }
}