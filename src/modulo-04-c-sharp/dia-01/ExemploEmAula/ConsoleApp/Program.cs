using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
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

            //agenda.RemoverContatosPorNome("Ben Hur");
            int opcao = 0;
            while (opcao != 6)
            {
                Console.WriteLine("Escolha uma opção");
                Console.WriteLine("1 - Adicionar contato");
                Console.WriteLine("2 - Listar contatos");
                Console.WriteLine("3 - Listar contatos ordenados por Nome");
                Console.WriteLine("4 - Remover contato por Nome");
                Console.WriteLine("5 - Remover contato por Numero");
                Console.WriteLine("6 - Sair");

                opcao = int.Parse(Console.ReadLine());
                string nomeContato;
                int numeroContato;

                switch (opcao)
                {
                    case 1:
                        Console.WriteLine("digite o nome e numero do contato");
                        nomeContato = Console.ReadLine();
                        numeroContato = int.Parse(Console.ReadLine());
                        agenda.AdicionarContato(new Contato()
                        {
                            Nome = nomeContato,
                            Numero = numeroContato
                        });
                        break;

                    case 2:
                        var listaContatos = agenda.ListarContatos();
                        foreach (var contato in listaContatos)
                        {
                            Console.WriteLine(contato.Nome + " - " + contato.Numero);
                        }
                        break;

                    case 3:
                        listaContatos = agenda.OrdenarContatosOrdenadoPorNome();
                        foreach (var contato in listaContatos)
                        {
                            Console.WriteLine(contato.Nome + " - " + contato.Numero);
                        }
                        break;

                    case 4:
                        Console.WriteLine("digite o nome do contato a ser removido");
                        nomeContato = Console.ReadLine();
                        agenda.RemoverContatosPorNome(nomeContato);
                        break;

                    case 5:
                        Console.WriteLine("digite o numero do contato a ser removido");
                        numeroContato = int.Parse(Console.ReadLine());
                        agenda.RemoverContatoPorNumero(numeroContato);
                        break;

                    default:
                        break;
                }
            }

        }
    }
}
