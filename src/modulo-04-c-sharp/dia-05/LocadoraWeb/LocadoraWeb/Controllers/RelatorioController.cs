using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using TrabalhoLocadora.Dominio;
using LocadoraWeb.Models;

namespace LocadoraWeb.Controllers
{
    public class RelatorioController : Controller
    {
        // GET: Relatorio
        public ActionResult JogosDisponiveis()
        {
            var baseDeDados = new BaseDeDados();
            var jogosDisponiveis = baseDeDados.BuscarJogoPorNome("");



            var model = new relatorioModel()
            {
                Jogos = jogosDisponiveis,
                NumeroDeJogos = jogosDisponiveis.Count,
                MediaPrecoJogos = jogosDisponiveis.Average(j => j.Preco),
                JogoMaisCaro = jogosDisponiveis.Where(j => j.Preco == (jogosDisponiveis.Max(j2 => j2.Preco))).First().Nome,
                JogoMaisBarato = jogosDisponiveis.Where(j => j.Preco == (jogosDisponiveis.Min(j2 => j2.Preco))).First().Nome
        };

            return View(model);
        }
    }
}