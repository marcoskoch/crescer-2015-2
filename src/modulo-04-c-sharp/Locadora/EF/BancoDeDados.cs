using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EF
{
    class BancoDeDados : DbContext
    {
        public BancoDeDados() : base("LOCADORA")
        {

        }

        public DbSet<Jogo> Jogo { get; set; }
        public DbSet<Cliente> Cliente { get; set; }
        public DbSet<Usuario> Usuario{ get; set; }
        public DbSet<Permissao> Permissao { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new JogoMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
            base.OnModelCreating(modelBuilder);
        }
    }

    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");
            HasKey(c => c.Id);
            Property(p => p.Nome).IsRequired();
        }
    }

    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuario");
            HasKey(u => u.IdUsuario);
            Property(u => u.Nome).IsRequired();
            Property(u => u.Email).IsRequired();
            Property(u => u.Senha).IsRequired();
            HasMany(u => u.Permissoes).WithMany(p => p.Usuarios).Map(m =>
                                                                    {
                                                                        m.ToTable("Usuario_Permissao");
                                                                        m.MapLeftKey("IdUsuario");
                                                                        m.MapRightKey("IdPermissao");
                                                                    });
        }
    }

    class PermissaoMap : EntityTypeConfiguration<Permissao>
    {
        public PermissaoMap()
        {
            ToTable("Permissao");
            HasKey(p => p.IdPermissao);
            Property(p => p.Nome).IsRequired();

        }
    }

    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");
            HasKey(p => p.Id);
            Property(p => p.Nome).IsRequired();
            Property(j => j.Categoria).IsRequired();
            Property(j => j.Selo).IsRequired();
            Property(p => p.Descricao).IsRequired();
            Property(p => p.TagVideo);
            Property(p => p.UrlImagem).HasColumnName("Url_Imagem");
            Property(p => p.IdCliente).HasColumnName("IdClienteLocacao");
            HasOptional(p => p.Cliente).WithMany().HasForeignKey(p => p.IdCliente);

            ////Adicionar campo na entidade
            //Property(p => p.IdCliente);

            ////Trocar isso:
            //HasOptional(p => p.Cliente).WithOptionalDependent().Map(m => m.MapKey("IdClienteLocacao"));
            ////Por isso:
            //HasOptional(p => p.Cliente).WithMany().HasForeignKey(p => p.IdCliente);
        }
    }
}
