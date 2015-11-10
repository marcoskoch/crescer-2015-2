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
    public class RelatorioController : BaseController
    {
        IJogoRepositorio jogoRepositorio = new JogoRepositorio();
        public ActionResult JogosFiltradosPorId(int id)
        {
            return View();
        }
        
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
        

    }
}