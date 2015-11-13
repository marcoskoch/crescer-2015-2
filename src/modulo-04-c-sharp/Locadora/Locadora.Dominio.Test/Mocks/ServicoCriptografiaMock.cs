using Locadora.Dominio.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Test.Mocks
{
    public class ServicoCriptografiaMock : IServicoCriptografia
    {
        public const string senhaCriptografada = "senhacriptografada";

        public string CriptografarSenha(string senha)
        {
            return senhaCriptografada;
        }
    }
}
