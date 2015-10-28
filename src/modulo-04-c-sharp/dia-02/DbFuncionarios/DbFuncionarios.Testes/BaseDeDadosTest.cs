using System;
using System.Text;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace DbFuncionarios.Testes
{
    /// <summary>
    /// Summary description for BaseDeDadosTest
    /// </summary>
    [TestClass]
    public class BaseDeDadosTest
    {
        [TestMethod]
        public void buscarFuncionarioPorNomeQueTenhaLu()
        {
            var baseDeDados = new BaseDeDados();
            var funcionarios = baseDeDados.BuscarPorNome("Lu");
            string[] nomeFuncionariosObtido = new string[2];
            for (int i = 0; i < funcionarios.Count; i++)
            {
                nomeFuncionariosObtido[i] = funcionarios[i].Nome;
            }

            Cargo desenvolvedor = new Cargo("Desenvolvedor", 190);
            Cargo analista = new Cargo("Analista", 250);
            Cargo gerente = new Cargo("Gerente", 550.5);

            string[] nomeFuncionariosEsperado = new string[2];
            nomeFuncionariosEsperado[0] = "Lucas Leal";
            nomeFuncionariosEsperado[1] = "Lucas Kauer";            

            Assert.AreEqual(nomeFuncionariosEsperado[0], nomeFuncionariosObtido[0]);
            Assert.AreEqual(nomeFuncionariosEsperado[1], nomeFuncionariosObtido[1]);
        }
    }
}
