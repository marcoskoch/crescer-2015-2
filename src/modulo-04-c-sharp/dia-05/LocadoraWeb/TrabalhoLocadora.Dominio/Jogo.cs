using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TrabalhoLocadora.Dominio
{
    public class Jogo
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public decimal Preco { get; set; }
        public string Categoria { get; set; }

        public Jogo (int id, string nome, decimal preco, string categoria)
        {
            this.Id = id;
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = categoria;
        }
    }
}
