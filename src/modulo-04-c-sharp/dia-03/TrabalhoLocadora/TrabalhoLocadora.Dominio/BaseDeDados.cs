using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace TrabalhoLocadora.Dominio
{
    public class BaseDeDados
    {
        public List<Jogo> ListaDeJogos { get; set; } 
        private string caminhoXML = @"C:\Users\Marcos\Documents\GitHub\crescer-2015-2\src\modulo-04-c-sharp\dia-03\TrabalhoLocadora\game_store.xml";

        public List<Jogo> BuscarJogoPorNome(string nome)
        {
            XElement jogos = XElement.Load(caminhoXML);
            ListaDeJogos = new List<Jogo>();

            foreach (XElement jogo in jogos.Elements("jogo"))
            {
                XElement name = jogo.Element("nome");
                ListaDeJogos.Add(new Jogo(int.Parse(jogo.Attribute("id").Value), name.Value.ToString(), double.Parse(jogo.Element("preco").Value.Replace(".", ",")), jogo.Element("categoria").Value.ToString()));
            }

            var resultado = ListaDeJogos.Where(j => j.Nome.ToLower().Contains(nome.ToLower())).ToList();

            return resultado;
        }

        public void InsereJogo(int id, string nome, string categoria, double preco)
        {
            XElement jogo = new XElement("jogo");
            jogo.SetAttributeValue("id", id);
            jogo.SetElementValue("nome", nome);
            jogo.SetElementValue("preco", preco);
            jogo.SetElementValue("categoria", categoria);

            XElement jogos = XElement.Load(caminhoXML);
            jogos.Add(jogo);
            jogos.Save(caminhoXML);
            
        }

        public void ExportarRelatorioJogos()
        {
            string caminhoArquivo = @"C:\Users\Marcos\Documents\GitHub\crescer-2015-2\src\modulo-04-c-sharp\dia-03\TrabalhoLocadora\relatorio.txt";

            var jogos = BuscarJogoPorNome("");
            int numeroDeJogos = jogos.Count;
            double mediaPrecoJogos = jogos.Average(j => j.Preco);
            var jogoMaisCaro = jogos.Where(j => j.Preco == (jogos.Max(j2 => j2.Preco))).First();
            var jogoMaisBarato = jogos.Where(j => j.Preco == (jogos.Min(j2 => j2.Preco))).First();
            var dataHoje = DateTime.Now;

            var writer = new StreamWriter(caminhoArquivo, false);

            writer.WriteLine("                             LOCADORA NUNES GAMES                               ");
            writer.WriteLine("{0}                                                              {1}", dataHoje.ToString("dd/MM/yyyy"), dataHoje.ToString("hh:mm:ss"));
            writer.WriteLine("                              Relatório de jogos                                ");
            writer.WriteLine("                                                                                ");
            writer.WriteLine("================================================================================");
            writer.WriteLine("ID        Categoria       Nome                          Preço         Disponivel");
            foreach (var item in jogos)
            {
                var nomeJogo = item.Nome;
                if (item.Nome.Length > 25)
                    nomeJogo = item.Nome.Substring(0, 24);

                writer.WriteLine("{0,2}       {1,10}       {2,-25}     {3,-9:C}            SIM", item.Id, item.Categoria, nomeJogo, item.Preco);
                //Console.WriteLine("Nome: {0} \r\nCategoria: {1}", item.Nome, item.Categoria);
                //Console.WriteLine(string.Format("Valor: {0:C} \r\n", item.Preco));
            }
            writer.WriteLine("-------------------------------------------------------------------------------");
            writer.WriteLine("Quantidade total de jogos: {0}", numeroDeJogos);
            writer.WriteLine("Valor médio por jogo: {0:C}", mediaPrecoJogos);
            writer.WriteLine("Jogo mais caro: {0}", jogoMaisCaro.Nome);
            writer.WriteLine("Jogo mais barato: {0}", jogoMaisBarato.Nome);
            writer.WriteLine("================================================================================");

            writer.Close();
        }
    } 
}
