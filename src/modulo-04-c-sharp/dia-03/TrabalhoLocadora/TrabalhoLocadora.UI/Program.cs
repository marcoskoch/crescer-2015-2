using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;
using TrabalhoLocadora.Dominio;

namespace TrabalhoLocadora.UI
{
    public class Program
    {
        static void Main(string[] args)
        {
            var baseDeDados = new BaseDeDados();

            int opcao = 0;
            string nomeParaBuscar, novoNome, novaCategoria, novoPreco;
            int novoId;

            while (opcao != Constants.FECHAR_APLICACAO)
            {
                Console.Clear();
                Console.WriteLine("Digite o numero de uma opção");
                Console.WriteLine("1 - Cadastrar um novo jogo");
                Console.WriteLine("2 - Realizar pesquisa de jogos por nome");
                Console.WriteLine("3 - Editar um jogo");
                Console.WriteLine("4 - Exportar relatorio de jogos em TXT");
                Console.WriteLine("5 - Sair");

                try
                {
                    opcao = int.Parse(Console.ReadLine());
                }
                catch (Exception)
                {
                    Console.Clear();
                    Console.WriteLine("Valor inválido, apenas números inteiros de 1 a 5 tecle ENTER para digitar novamente!");
                    Console.ReadLine();
                }
                

                switch (opcao)
                {
                    case 1:
                        Console.Clear();
                        Console.WriteLine("Digite o id do novo jogo");
                        novoId = int.Parse(Console.ReadLine());
                        Console.Clear();
                        Console.WriteLine("Digite o nome do novo jogo");
                        novoNome = Console.ReadLine();
                        Console.Clear();
                        Console.WriteLine("Digite a categoria do novo jogo");
                        novaCategoria = Console.ReadLine();
                        Console.Clear();
                        Console.WriteLine("Digite o preço do novo jogo");
                        novoPreco = Console.ReadLine();
                        Console.Clear();
                        baseDeDados.InsereJogo(novoId, novoNome, novaCategoria, double.Parse(novoPreco.Replace(".", ",")));
                        break;

                    case 2:
                        Console.Clear();
                        Console.WriteLine("Digite o nome do jogo que procura");
                        nomeParaBuscar = Console.ReadLine();
                        Console.Clear();
                        var jogos = baseDeDados.BuscarJogoPorNome(nomeParaBuscar);

                        foreach (var item in jogos)
                        {
                            Console.WriteLine("Nome: {0} \r\nCategoria: {1}",item.Nome,item.Categoria);
                            Console.WriteLine(string.Format("Valor: {0:C} \r\n", item.Preco));
                        }
                        Console.ReadLine();
                        break;

                    case 3:
                        break;

                    case 4:
                        Console.Clear();
                        baseDeDados.exportarRelatorioJogos();
                        Console.WriteLine("Relatório gerado com sucesso!");
                        Console.ReadLine();
                        break;

                    default:
                        break;
                }
            }
        }

        static class Constants
        {
            public const int FECHAR_APLICACAO = 5;

        }
    }
}
