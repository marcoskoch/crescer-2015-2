using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Principal;
using System.Threading;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Seguranca.Filters
{
    public class Autorizador : AuthorizeAttribute
    {
        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            UsuarioLogado usuarioLogado = filterContext.HttpContext.Session["USUARIO_LOGADO"] as UsuarioLogado;

            var identidade = new GenericIdentity(usuarioLogado.Email);
            string[] roles = usuarioLogado.Permissoes;

            var principal = new GenericPrincipal(identidade, roles);

            Thread.CurrentPrincipal = principal;
            HttpContext.Current.User = principal;

            base.OnAuthorization(filterContext);
        }
    }
}