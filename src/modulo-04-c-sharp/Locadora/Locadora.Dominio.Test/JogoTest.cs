using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class JogoTest
    {
        [TestMethod]
        public void LocacaoParaClienteTemIdCorreto()
        {
            Jogo jogo = new Jogo();

            jogo.IdCliente = 1;

            Assert.AreEqual(1, jogo.IdCliente);
        }

        [TestMethod]
        public void JogoComConstrutorVazio()
        {
            Jogo jogo = new Jogo();
            Assert.AreEqual(Selo.Bronze, jogo.Selo);
        }
    }
}

