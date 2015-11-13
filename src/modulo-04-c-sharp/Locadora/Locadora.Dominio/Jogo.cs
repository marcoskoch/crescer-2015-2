using System;
using System.Globalization;
using System.Text;

namespace Locadora.Dominio
{
    public class Jogo : EntidadeBase
    {
        public string Nome { get; set; }

        public Categoria Categoria { get; set; }
        
        public Selo Selo { get; set; }

        public string Descricao { get; set; }

        public string UrlImagem { get; set; }

        public string TagVideo { get; set; }

        public int? IdCliente { get; set; }
        public Cliente Cliente { get; set; }

        //public bool EstaLocado { get; }

        public Jogo()
        {
            this.Selo = Selo.Bronze;
        }

        public Jogo(int id, Cliente cliente = null) : base()
        {
            this.Id = id;
            this.Cliente = cliente;
        }

        public void LocarPara(int idCliente)
        {
            this.IdCliente = idCliente;
        }

        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendLine("Id: " + this.Id);
            builder.AppendLine("Nome: " + this.Nome);
            builder.AppendLine("Categoria: " + this.Categoria);

            return builder.ToString();
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if(obj.GetType() == typeof(Jogo))
            {
                Jogo jogoComp = (Jogo)obj;

                return this.Id == jogoComp.Id
                    && this.Nome == jogoComp.Nome
                    && this.Categoria == jogoComp.Categoria
                    && this.Cliente == jogoComp.Cliente;
            }

            return false;
        }
    }
}
