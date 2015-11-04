using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using TrabalhoLocadora.Dominio;

namespace LocadoraWeb.Models
{
    public class relatorioModel
    {
        public List<Jogo> Jogos { get; set; }
        public int NumeroDeJogos { get; set; }
        public decimal MediaPrecoJogos { get; set; }
        public string JogoMaisCaro { get; set; }
        public string JogoMaisBarato { get; set; }

    }
}