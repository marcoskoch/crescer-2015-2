namespace EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Autenticacao : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Permissao",
                c => new
                    {
                        IdPermissao = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.IdPermissao);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        IdUsuario = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false),
                        Email = c.String(nullable: false),
                        Senha = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.IdUsuario);
            
            CreateTable(
                "dbo.Usuario_Permissao",
                c => new
                    {
                        IdUsuario = c.Int(nullable: false),
                        IdPermissao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdUsuario, t.IdPermissao })
                .ForeignKey("dbo.Usuario", t => t.IdUsuario, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.IdPermissao, cascadeDelete: true)
                .Index(t => t.IdUsuario)
                .Index(t => t.IdPermissao);
            
        }
        
        public override void Down()
        {
            AddColumn("dbo.Jogo", "Id", c => c.Int(nullable: false, identity: true));
            AddColumn("dbo.Cliente", "Id", c => c.Int(nullable: false, identity: true));
            DropForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Cliente");
            DropForeignKey("dbo.Usuario_Permissao", "IdPermissao", "dbo.Permissao");
            DropForeignKey("dbo.Usuario_Permissao", "IdUsuario", "dbo.Usuario");
            DropIndex("dbo.Usuario_Permissao", new[] { "IdPermissao" });
            DropIndex("dbo.Usuario_Permissao", new[] { "IdUsuario" });
            DropPrimaryKey("dbo.Jogo");
            DropPrimaryKey("dbo.Cliente");
            DropColumn("dbo.Jogo", "IdPermissao");
            DropColumn("dbo.Cliente", "IdPermissao");
            DropTable("dbo.Usuario_Permissao");
            DropTable("dbo.Usuario");
            DropTable("dbo.Permissao");
            AddPrimaryKey("dbo.Jogo", "Id");
            AddPrimaryKey("dbo.Cliente", "Id");
            AddForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Cliente", "Id");
        }
    }
}
