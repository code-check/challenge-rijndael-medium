using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RijndaelMedium
{
    interface IRijndael
    {
        void SetKey(byte[] key);

        byte[] Encrypt(byte[] data);

        byte[] Decrypt(byte[] data);
    }
}
