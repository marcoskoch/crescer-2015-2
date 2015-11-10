﻿using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EF
{
    public class JogoRepositorio : IJogoRepositorio
    {

        public IList<Jogo> BuscarTodos()
        {
            List<Jogo> jogos = new List<Jogo>();
            using (var db = CriaBancoDeDados())
            {
                jogos = db.Jogo.ToList();
            }
            return jogos;
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            List<Jogo> jogos = new List<Jogo>();
            using (var db = CriaBancoDeDados())
            {
                return db.Jogo.Where(p => p.Nome.Contains(nome)).ToList();
            }
        }

        public Jogo BuscarPorId(int id)
        {
            using (var db = CriaBancoDeDados())
            {
                return db.Jogo.Where(j => j.Id == id).FirstOrDefault();
            }
        }

        private BancoDeDados CriaBancoDeDados()
        {
            return new BancoDeDados();
        }

        public int Criar(Jogo jogo)
        {
            using (var db = new BancoDeDados())
            {
                db.Jogo.Add(jogo);
                return db.SaveChanges();
            }
        }

        public int Atualizar(Jogo jogo)
        {
            throw new NotImplementedException();
        }

        public int Excluir(int id)
        {
            throw new NotImplementedException();
        }
    }
}
