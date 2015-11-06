using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{

    public class RelatorioController : Controller
    {
        private IJogoRepositorio jogoRepositorio = new Repositorio.ADO.JogoRepositorio();

        public ActionResult JogosDisponiveis(string nome)
        {
            var model = new RepositorioModel();
            IList<Dominio.Jogo> jogos;
            if (nome != null)
            {
                jogos = jogoRepositorio.BuscarPorNome(nome);
            }
            else
            {
                jogos = jogoRepositorio.BuscarTodos();
            }

            model = ListarJogosModel(jogos);

            return View(model);
        }

        private RepositorioModel ListarJogosModel(IList<Dominio.Jogo> jogos)
        {
            var model = new RepositorioModel();
            foreach (var jogo in jogos)
            {
                model.Jogos.Add(new JogoModel() { Id = jogo.Id, Nome = jogo.Nome, Categoria = jogo.Categoria.ToString(), Preco = jogo.Preco });
            }

            model.NumeroDeJogos = jogos.Count();
            model.MediaPrecoJogos = jogos.Average(j => j.Preco);
            model.JogoMaisCaro = jogos.Where(j => j.Preco == (jogos.Max(j2 => j2.Preco))).First().Nome;
            model.JogoMaisBarato = jogos.Where(j => j.Preco == (jogos.Min(j2 => j2.Preco))).First().Nome;

            return model;
        }
    }
}