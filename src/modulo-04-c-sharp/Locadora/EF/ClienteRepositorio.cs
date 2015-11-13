using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EF
{
    public class ClienteRepositorio
    {
        public IList<Cliente> BuscarTodosClientes()
        {
            using (var db = new BancoDeDados())
            {
                return db.Cliente.ToList();
            }
        }

        public IList<Cliente> BuscarPorNome(string nome)
        {
            List<Jogo> jogos = new List<Jogo>();
            using (var db = new BancoDeDados())
            {
                return db.Cliente.Where(c => c.Nome.Contains(nome)).ToList();
            }
        }

        public Cliente BuscarPorId(int id)
        {
            using (var db = new BancoDeDados())
            {
                return db.Cliente.Where(j => j.Id == id).FirstOrDefault();
            }
        }
    }
}
