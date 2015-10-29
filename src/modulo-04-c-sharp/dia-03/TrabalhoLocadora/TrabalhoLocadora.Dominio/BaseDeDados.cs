using System;
using System.Collections.Generic;
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
    } 
}
