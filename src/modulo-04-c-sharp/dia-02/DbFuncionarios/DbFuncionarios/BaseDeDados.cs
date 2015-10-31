using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace DbFuncionarios
{
    public class BaseDeDados
    {
        public List<Funcionario> Funcionarios
        {
            get; private set;
        }

        public BaseDeDados()
        {
            CriarBase();
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            var resultado = Funcionarios.OrderBy(funcionario => funcionario.Cargo.Titulo).ToList();

            return resultado;
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            var resultado = Funcionarios.Where(funcionario => funcionario.Nome.ToLower().Contains(nome.ToLower())).ToList();

            return resultado;
        }

        public IList<dynamic> BuscaRapida(string nome)
        {

            var resultado = from f in Funcionarios
                            where f.Nome.ToLower().Contains(nome.ToLower())
                            select new
                            {
                                Nome = f.Nome,
                                TituloCargo = f.Cargo.Titulo
                            };

            return resultado.ToList<dynamic>();
        }

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] e)
        {
            var resultado = Funcionarios.Where(f => e.Contains(f.TurnoTrabalho));

            return resultado.ToList();
        }

        public IList<dynamic> QtdFuncionariosPorTurno()
        {
            var resultado = from f in Funcionarios
                            group f by f.TurnoTrabalho into f1
                            select new
                            {
                                TurnoTrabalho = f1.First().TurnoTrabalho,
                                Quantidade = f1.Count()
                            };

            return resultado.ToList<dynamic>();
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            var resultado = Funcionarios.Where(funcionario => funcionario.Cargo.Titulo.Equals(cargo.Titulo)).ToList();

            return resultado;
        }

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            int maxIdade = idade + 5;
            int minIdade = idade - 5;
            var dataMin= (DateTime.Now.AddYears(-maxIdade));
            var dataMax = (DateTime.Now.AddYears(-minIdade));

            var resultado = Funcionarios.Where(f => f.DataNascimento >= dataMin && f.DataNascimento <= dataMax);

            return resultado.ToList();
        }

        public double SalarioMedio()
        {
            return Funcionarios.Average(f => f.Cargo.Salario);
        }

        public double SalarioMedio(params TurnoTrabalho[] e)
        {
            var funcionariosPorTurno = BuscarPorTurno(e);
            return funcionariosPorTurno.Average(f => f.Cargo.Salario);
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            var resultado = Funcionarios.Where(f => f.DataNascimento.Month == DateTime.Now.Month);

            return resultado.ToList();
        }

        public dynamic FuncionarioMaisComplexo()
        {
            string consoantes = "[b-df-hj-np-tv-z]";
            Regex regexConsoantes = new Regex(consoantes, RegexOptions.IgnoreCase);

            var maiorNumeroDeConsoantes = Funcionarios.Max(funcionario => regexConsoantes.Matches(funcionario.Nome).Count);

            var resultado = (from f in Funcionarios
                            select new
                            {
                                Nome = f.Nome,
                                SalarioBR = string.Format("{0:C}", f.Cargo.Salario),
                                SalarioUS = string.Format(CultureInfo.GetCultureInfo("en-US"), "{0:C}", f.Cargo.Salario)
                            }).First(f => regexConsoantes.Matches(f.Nome).Count == maiorNumeroDeConsoantes);


            return resultado;
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor = new Cargo("Desenvolvedor", 190);
            Cargo analista = new Cargo("Analista", 250);
            Cargo gerente = new Cargo("Gerente", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Lucas Leal", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Jean Pinzon", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Rafael Benetti", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Maurício Borges", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Leandro Andreolli", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Felipe Nervo", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Lucas Kauer", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Eduardo Arnold", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Gabriel Alboy", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = analista;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Carlos Henrique", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = analista;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Margarete Ricardo", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = gerente;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }
    }
}
