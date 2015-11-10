using EF;
using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : BaseController
    {
        IJogoRepositorio jogoRepositorio = new JogoRepositorio();
        public ActionResult DetalhesDoJogo(int id)
        {
            Jogo jogoEncontrado = jogoRepositorio.BuscarPorId(id);

            var jogoModel = new DetalheJogoModel(jogoEncontrado);

            return View(jogoModel);
        }

        public ActionResult Manter(int? id)
        {
            if (id.HasValue)
            {
                Jogo jogoEncontrado = jogoRepositorio.BuscarPorId(Convert.ToInt32(id));

                var model = new JogoModel()
                {
                    IdJogo = jogoEncontrado.Id,
                    Nome = jogoEncontrado.Nome,
                    Preco = jogoEncontrado.Preco,
                    Categoria = jogoEncontrado.Categoria,
                    Selo = jogoEncontrado.Selo,
                    Descricao = jogoEncontrado.Descricao,
                    UrlImagem = jogoEncontrado.UrlImagem,
                    TagVideo = jogoEncontrado.TagVideo                
                };

                return View(model);
            }
            else
            {
                return View();
            }
        }

        [HttpPost]
        public ActionResult Salvar(JogoModel model)
        {
            if (ModelState.IsValid)
            {
                Jogo jogoParaSalvar = new Jogo()
                {
                    Nome = model.Nome,
                    Preco = model.Preco,
                    Categoria = model.Categoria,
                    Selo = model.Selo,
                    Descricao = model.Descricao,
                    UrlImagem = model.UrlImagem,
                    TagVideo = model.TagVideo
                };
                jogoRepositorio.Criar(jogoParaSalvar);
                TempData["Mensagem"] = "Jogo salvo com sucesso!";

                return RedirectToAction("JogosDisponiveis", "Relatorio");
            }
            else
            {
                return View("Manter", model);
            }
        }
    }
}