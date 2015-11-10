using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class JogoModel
    {
        public int? IdJogo { get; set; }

        [Required]
        public string Nome { get; set; }

        [Required]
        public string Descricao { get; set; }

        [Required]
        public decimal Preco { get; set; }

        [Required]
        public Categoria Categoria { get; set; }

        [Required]
        public Selo Selo { get; set; }

        public string UrlImagem { get; set; }

        public string TagVideo { get; set; }
    }
}