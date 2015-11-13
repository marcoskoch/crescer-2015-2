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
    public class LocacaoController : Controller
    {
        IJogoRepositorio jogoRepositorio = new JogoRepositorio();
        ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

        public ActionResult Index(string nome)
        {
            IList<Jogo> jogosEncontrados = null;

            if (string.IsNullOrEmpty(nome))
            {
                jogosEncontrados = jogoRepositorio.JogosDisponiveis();
            }
            else
            {
                jogosEncontrados = jogoRepositorio.BuscarPorNome(nome);
            }

            RelatorioJogosDisponiveisModel model = new RelatorioJogosDisponiveisModel(jogosEncontrados);

            return View(model);
        }

        public ActionResult LocarJogo(int id)
        {

            Jogo jogoEncontrado = jogoRepositorio.BuscarPorId(id);
            ServicoLocacaoValor servicoLocacao = new ServicoLocacaoValor();

            var jogoModel = new LocarJogoModel(jogoEncontrado)
            {
                Preco = servicoLocacao.ValorLocacao(jogoEncontrado.Selo.ToString())
            };

            return View(jogoModel);
        }

        public ActionResult ConcluirLocacao(LocarJogoModel jogoLocar)
        {
            Jogo jogoLocado = jogoRepositorio.BuscarPorId(jogoLocar.IdJogo);
            Cliente clienteJogo = clienteRepositorio.BuscarPorNome(jogoLocar.Cliente).FirstOrDefault();

            jogoLocado.IdCliente = clienteJogo.Id;
            jogoRepositorio.Atualizar(jogoLocado);

            return RedirectToAction("Index", "Locacao");
        }

        public JsonResult ClientesAutocomplete(string term)
        {
            IList<Cliente> clientesEncontrados = null;
            clientesEncontrados = clienteRepositorio.BuscarTodosClientes();

            if (string.IsNullOrEmpty(term))
            {
                clientesEncontrados = clienteRepositorio.BuscarTodosClientes();
            }
            else
            {
                clientesEncontrados = clienteRepositorio.BuscarPorNome(term);
            }

            var json = clientesEncontrados.Select(x => new { label = x.Nome });

            return Json(json, JsonRequestBehavior.AllowGet);
        }
    }
}