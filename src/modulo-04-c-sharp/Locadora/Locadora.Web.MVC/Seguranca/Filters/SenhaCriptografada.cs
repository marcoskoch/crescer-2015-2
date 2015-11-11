using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Web;

namespace Locadora.Web.MVC.Seguranca.Filters
{
    public class SenhaCriptografada
    {
        private string ToHex(byte[] bytes, bool upperCase)
        {
            StringBuilder result = new StringBuilder(bytes.Length * 2);

            for (int i = 0; i < bytes.Length; i++)
                result.Append(bytes[i].ToString(upperCase ? "X2" : "x2"));

            return result.ToString();
        }

        public string SaltedHash(string usuario, string senha)
        {
            var salt = System.Text.Encoding.UTF8.GetBytes(usuario);
            var password = System.Text.Encoding.UTF8.GetBytes(senha);
            var hmacMD5 = new HMACMD5(salt);
            var saltedHash = hmacMD5.ComputeHash(password);

            return ToHex(saltedHash, true);
        }
    }
}