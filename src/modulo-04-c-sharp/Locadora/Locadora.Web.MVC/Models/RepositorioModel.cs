using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RepositorioModel
    {
        public List<JogoModel> Jogos { get; set; }
        public int NumeroDeJogos { get; set; }
        public decimal MediaPrecoJogos { get; set; }
        public string JogoMaisCaro { get; set; }
        public string JogoMaisBarato { get; set; }

        public RepositorioModel()
        {
            Jogos = new List<JogoModel>();
        }
    }
}