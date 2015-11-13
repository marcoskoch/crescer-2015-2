using EF;
using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Servicos;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca.Filters;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador(Roles = "OPERADOR")]
    public class DevolucaoController : Controller
    {
        IJogoRepositorio jogoRepositorio = new JogoRepositorio();
        ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

        public ActionResult Index()
        {
            IList<Jogo> jogosEncontrados = null;
            jogosEncontrados = jogoRepositorio.JogosLocados();
            RelatorioJogosDisponiveisModel model = new RelatorioJogosDisponiveisModel(jogosEncontrados);

            return View(model);
        }

        public ActionResult DevolverJogo(int id)
        {

            Jogo jogoEncontrado = jogoRepositorio.BuscarPorId(id);
            ServicoLocacaoValor servicoLocacao = new ServicoLocacaoValor();

            var jogoModel = new LocarJogoModel(jogoEncontrado)
            {
                Cliente = clienteRepositorio.BuscarPorId(Convert.ToInt32(jogoEncontrado.IdCliente)).Nome,
                Preco = servicoLocacao.ValorLocacao(jogoEncontrado.Selo.ToString())
            };

            return View(jogoModel);
        }

        public ActionResult ConcluirDevolucao(LocarJogoModel jogoLocar)
        {
            Jogo jogoLocado = jogoRepositorio.BuscarPorId(jogoLocar.IdJogo);

            jogoLocado.IdCliente = null;
            jogoRepositorio.Atualizar(jogoLocado);

            return RedirectToAction("Index", "Locacao");
        }
    }
}