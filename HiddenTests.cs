using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RijndaelMedium
{
    [TestFixture]
    public class HiddenTests : Rijndael
    {
        [Test]
        public void Ensure() 
        {
            var rnd = new Random();
            var key = new byte[32];
            var data = new byte[16]; // Single block!
            var backup = new byte[16];

            for (int i = 0; i < 10; i++)
            {
                rnd.NextBytes(key);
                rnd.NextBytes(data);
                Array.Copy(data, backup, data.Length);

                SetKey(key);
                Assert.AreEqual(backup, Decrypt(Encrypt(data)));
            }
        }
    }
}
