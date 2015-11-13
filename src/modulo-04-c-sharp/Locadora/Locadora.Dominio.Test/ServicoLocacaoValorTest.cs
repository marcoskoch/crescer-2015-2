using System;
using System.Text;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio.Servicos;

namespace Locadora.Dominio.Test
{
    /// <summary>
    /// Summary description for ServicoLocacaoValor
    /// </summary>
    [TestClass]
    public class ServicoLocacaoValorTest
    {
        [TestMethod]
        public void ValorComSeloOuro()
        {
            ServicoLocacaoValor servico = new ServicoLocacaoValor();
            var valor = servico.ValorLocacao("Ouro");

            Assert.AreEqual(15, valor);
        }

        [TestMethod]
        public void ValorComSeloPrata()
        {
            ServicoLocacaoValor servico = new ServicoLocacaoValor();
            var valor = servico.ValorLocacao("Prata");

            Assert.AreEqual(10, valor);
        }

        [TestMethod]
        public void ValorComSeloBronze()
        {
            ServicoLocacaoValor servico = new ServicoLocacaoValor();
            var valor = servico.ValorLocacao("Bronze");

            Assert.AreEqual(5, valor);
        }
    }
}
