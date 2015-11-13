using System;
using System.Text;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Dominio.Test
{
    /// <summary>
    /// Summary description for ClienteTest
    /// </summary>
    [TestClass]
    public class ClienteTest
    {
        [TestMethod]
        public void ClienteComIdUmENomeMarcos()
        {
            Cliente cliente = new Cliente(1)
            {
                Nome = "Marcos"
            };

            Assert.AreEqual(1, cliente.Id);
            Assert.AreEqual("Marcos", cliente.Nome);
        }
    }
}
