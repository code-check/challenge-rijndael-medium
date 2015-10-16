using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
//BEGIN_CHALLENGE
using System.Security.Cryptography;
using System.IO;
//END_CHALLENGE

namespace RijndaelMedium
{
    public class Rijndael : IRijndael
    {
        //BEGIN_CHALLENGE
        private RijndaelManaged Cipher = new RijndaelManaged();
        //END_CHALLENGE

        public void SetKey(byte[] key)
        {
            //BEGIN_CHALLENGE
            Cipher.Mode = CipherMode.ECB;
            Cipher.Padding = PaddingMode.None;
            Cipher.Key = key;
            return; 
            //END_CHALLENGE
            throw new NotImplementedException();
        }

        public byte[] Encrypt(byte[] data)
        {
            //BEGIN_CHALLENGE
            using (var cryptor = Cipher.CreateEncryptor() as RijndaelManagedTransform)
            using (var mStream = new MemoryStream())
            using (var cStream = new CryptoStream(mStream, cryptor, CryptoStreamMode.Write))
            {
                byte[] ret = new byte[data.Length];
                cStream.Write(data, 0, data.Length);
                cStream.FlushFinalBlock();
                mStream.Position = 0;
                mStream.Read(ret, 0, ret.Length);
                return ret;
            }
            //END_CHALLENGE
            throw new NotImplementedException();
        }

        public byte[] Decrypt(byte[] data)
        {
            //BEGIN_CHALLENGE
            using (var cryptor = Cipher.CreateDecryptor() as RijndaelManagedTransform)
            using (var mStream = new MemoryStream())
            using (var cStream = new CryptoStream(mStream, cryptor, CryptoStreamMode.Write))
            {
                byte[] ret = new byte[data.Length];
                cStream.Write(data, 0, data.Length);
                cStream.FlushFinalBlock();
                mStream.Position = 0;
                mStream.Read(ret, 0, ret.Length);
                return ret;
            }
            //END_CHALLENGE
            throw new NotImplementedException();
        }
    }
}
