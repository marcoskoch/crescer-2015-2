﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Repositorio.XML
{
    public abstract class RepositorioBase
    {
        protected abstract string NomeArquivoXml { get; }

        protected XElement CarregarBaseXml()
        {
            return XElement.Load(@"C:\Users\Marcos\Documents\GitHub\crescer-2015-2\src\modulo-04-c-sharp\Locadora\Locadora.Web.MVC\bin\" + NomeArquivoXml);
        }

        protected void SalvarDbXml(XElement db)
        {
            db.Save(NomeArquivoXml);
        }

        protected virtual int BuscarUltimoIdInserido()
        {
            IEnumerable<XElement> registros = CarregarBaseXml().Elements();

            if (registros.Count() < 1)
            {
                return 0;
            }

            return Convert.ToInt32(registros.Last().Attribute("id").Value);
        }
    }
}
