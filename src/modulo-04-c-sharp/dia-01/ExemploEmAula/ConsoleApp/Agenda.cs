using System;
using System.Collections.Generic;
using System.Linq;

namespace ConsoleApp
{
    public class Agenda
    {
        private List<Contato> contatos = new List<Contato>();        

        public int QuantidadeContatos { get { return contatos.Count; } }

        public void AdicionarContato(Contato contato)
        {
            contatos.Add(contato);
        }

        //public void RemoverContato(string nomeContato)
        //{
        //    foreach (var contato in contatos)
        //    {
        //        if (contato.Nome == nomeContato)
        //        {
        //            contatos.Remove(contato);
        //            break;
        //        }
        //    }
        //}

        public void RemoverContatos(List<Contato> contatosASeremRemovidos)
        {
            foreach (var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }
        }

        public void RemoverContatosPorNome(string nomeContato)
        {
            var contatosASeremRemovidos = new List<Contato>();

            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Nome == nomeContato)
                    contatosASeremRemovidos.Add(contatos[i]);
            }

            RemoverContatos(contatosASeremRemovidos);
        }

        public void RemoverContatoPorNumero(int numeroContato)
        {
            var contatosASeremRemovidos = new List<Contato>();

            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Numero == numeroContato)
                    contatosASeremRemovidos.Add(contatos[i]);
            }

            RemoverContatos(contatosASeremRemovidos);
        }

        public List<Contato> ListarContatos()
        {
            var listaContatos = new List<Contato>();
            foreach (var contato in contatos)
            {
                listaContatos.Add(contato);
            }

            return listaContatos;
        }

        public List<Contato> OrdenarContatosOrdenadoPorNome()
        {
            var listaContatos = ListarContatos();

            return listaContatos.OrderBy(o => o.Nome).ToList();
        }
    }
}
