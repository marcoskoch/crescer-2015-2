using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos
{
    public class ServicoLocacaoValor
    {
        public decimal ValorLocacao(string selo)
        {
            decimal valor = 0;
            if (selo == "Ouro")
                valor = 15;
            if (selo == "Prata")
                valor = 10;
            if (selo == "Bronze")
                valor = 5;

            return valor;
        }
    }
}
