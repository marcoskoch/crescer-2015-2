using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ConsoleApp.Testes
{
    [TestClass]
    public class AgendaTestes
    {
        [TestMethod]
        public void AgendaTemUmContato()
        {
            var agenda = new Agenda();
            var contato = new Contato() { Nome = "Júlio César", Numero = 977454545 };

            agenda.AdicionarContato(contato);

            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }

        [TestMethod]
        public void AgendaCom3ContatosRemoverDoisContatosComMesmoNome()
        {
            var contato1 = new Contato()
            {
                Nome = "Fabricio",
                Numero = 1515515
            };

            var contato2 = new Contato()
            {
                Nome = "Ben Hur",
                Numero = 666
            };

            var contato3 = new Contato()
            {
                Nome = "Ben Hur",
                Numero = 666
            };

            var agenda = new Agenda();
            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);
            agenda.AdicionarContato(contato3);

            agenda.RemoverContatosPorNome("Ben Hur");

            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }
    }

}
