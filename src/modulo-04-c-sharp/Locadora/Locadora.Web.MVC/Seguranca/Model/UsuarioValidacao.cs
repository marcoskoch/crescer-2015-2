using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Seguranca.Model
{
    public class UsuarioValidacao
    {
        public string Email { get; set; }
        public string Senha { get; set; }

        public UsuarioValidacao(string email, string senha)
        {
            Email = email;
            Senha = senha;
        }
    }
}