﻿using EF;
using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca.Filters;
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

        [Autorizador(Roles = "OPERADOR")]
        public ActionResult DetalhesDoJogo(int id)
        {
            Jogo jogoEncontrado = jogoRepositorio.BuscarPorId(id);

            var jogoModel = new DetalheJogoModel(jogoEncontrado);

            return View(jogoModel);
        }

        [Autorizador(Roles = "ADMIN")]
        public ActionResult Manter(int? id)
        {
            if (id.HasValue)
            {
                Jogo jogoEncontrado = jogoRepositorio.BuscarPorId(Convert.ToInt32(id));

                var model = new JogoModel()
                {
                    IdJogo = jogoEncontrado.Id,
                    Nome = jogoEncontrado.Nome,
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

        [Autorizador(Roles = "ADMIN")]
        [HttpPost]
        public ActionResult Salvar(JogoModel model)
        {
            if (ModelState.IsValid)
            {
                Jogo jogoParaSalvar = new Jogo()
                {
                    Id = Convert.ToInt32(model.IdJogo),
                    Nome = model.Nome,
                    Categoria = model.Categoria,
                    Selo = model.Selo,
                    Descricao = model.Descricao,
                    UrlImagem = model.UrlImagem,
                    TagVideo = model.TagVideo
                };
                if (jogoParaSalvar.Id == 0)
                {
                    jogoRepositorio.Criar(jogoParaSalvar);
                }
                else
                {
                    jogoRepositorio.Atualizar(jogoParaSalvar);
                }
                
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