using System;
using System.Globalization;
using System.Text;

namespace Locadora.Dominio
{
    public class Jogo : EntidadeBase
    {
        public string Nome { get; set; }

        public decimal Preco { get; set; }

        public Categoria Categoria { get; set; }
        
        public Selo Selo { get; set; }

        public string Descricao { get; set; }

        public string UrlImagem { get; set; }

        public string TagVideo { get; set; }

        public Cliente Cliente { get; private set; }
        
        public Jogo()
        {
            this.Selo = Selo.Bronze;
        }

        public Jogo(int id, Cliente cliente = null) : base()
        {
            this.IdPermissao = id;
            this.Cliente = cliente;
        }

        public void LocarPara(Cliente cliente)
        {
            this.Cliente = cliente;
        }

        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendLine("Id: " + this.IdPermissao);
            builder.AppendLine("Nome: " + this.Nome);
            builder.AppendLine("Preço: " + this.Preco.ToString("C", CultureInfo.GetCultureInfo("pt-BR")));
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

                return this.IdPermissao == jogoComp.IdPermissao
                    && this.Nome == jogoComp.Nome
                    && this.Preco == jogoComp.Preco
                    && this.Categoria == jogoComp.Categoria
                    && this.Cliente == jogoComp.Cliente;
            }

            return false;
        }
    }
}
