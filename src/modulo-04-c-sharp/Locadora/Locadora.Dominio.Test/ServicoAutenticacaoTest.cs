using System;
using System.Text;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio.Test.Mocks;
using Locadora.Dominio.Servicos;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class ServicoAutenticacaoTest
    {
        [TestMethod]
        public void VerificaoSenhaUsuario()
        {
            ServicoAutenticacao servico = CriarServicoAutenticacao();
            Usuario user = servico.BuscarPorAutenticacao("marcos.koch@cwi.com.br", "123");

            Assert.IsNotNull(user);
        }

        private ServicoAutenticacao CriarServicoAutenticacao()
        {
            return new ServicoAutenticacao(new UsuarioRepositorioMock(), new ServicoCriptografiaMock());
        }
    }
}
