using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Test.Mocks
{
    public class UsuarioRepositorioMock : IUsuarioRepositorio
    {
        public Usuario BuscarPorEmail(string email)
        {
            return Db().FirstOrDefault(u => u.Email.Equals(email));
        }

        private IList<Usuario> Db()
        {
            var usuarios = new List<Usuario>();

            var usuario1 = new Usuario()
            {
                Email = "marcos.koch@cwi.com.br",
                Senha = "senhacriptografada"
            };

            usuarios.Add(usuario1);
            return usuarios;
        }
    }
}
