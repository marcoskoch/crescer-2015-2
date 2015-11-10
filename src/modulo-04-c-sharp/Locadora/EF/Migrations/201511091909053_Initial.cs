namespace EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Jogo",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false),
                        Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Categoria = c.Int(nullable: false),
                        Selo = c.Int(nullable: false),
                        Descricao = c.String(nullable: false),
                        Url_Imagem = c.String(),
                        TagVideo = c.String(),
                        IdClienteLocacao = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdClienteLocacao)
                .Index(t => t.IdClienteLocacao);

            CreateTable(
                "dbo.Selo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Descricao = c.String(nullable: false, maxLength: 250),
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Categoria",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Descricao = c.String(nullable: false, maxLength: 250),
                })
                .PrimaryKey(t => t.Id);            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Cliente");
            DropIndex("dbo.Jogo", new[] { "IdClienteLocacao" });
            DropTable("dbo.Jogo");
            DropTable("dbo.Cliente");
        }
    }
}
