using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EF.DbFirst
{
    class BancoDeDados : DbContext
    {
        public BancoDeDados() : base("LOCADORA")
        {

        }

        public DbSet<Jogo> Jogo { get; set; }
        public DbSet<Cliente> Cliente { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new JogoMap());
            base.OnModelCreating(modelBuilder);
        }
    }

    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");
            HasKey(c => c.IdPermissao);
            Property(p => p.Nome).IsRequired();
        }
    }

    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");
            HasKey(p => p.IdPermissao);
            Property(p => p.Nome).IsRequired();
            Property(p => p.Preco).IsRequired();
            Property(p => p.Descricao).IsRequired();
            Property(p => p.TagVideo);
            Property(p => p.UrlImagem).HasColumnName("Url_Imagem");
            HasOptional(p => p.Cliente).WithOptionalDependent().Map(m => m.MapKey("IdClienteLocacao"));
        }
    }
}
