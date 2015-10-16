using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace RijndaelMedium
{
    [TestFixture]
    public class Tests : Rijndael
    {
        [Test]
        public void EncryptCase1()
        {
            byte[] data = ToBytes("3243f6a8885a308d313198a2e0370734");
            byte[] key = ToBytes("2b7e151628aed2a6abf7158809cf4f3c");
            SetKey(key);
            string result = String.Join("", Encrypt(data).Select(x => x.ToString("x2")));
            Assert.AreEqual("3925841d02dc09fbdc118597196a0b32", result);
        }

        [Test]
        public void EncryptCase2()
        {
            byte[] data = ToBytes("3243f6a8885a308d313198a2e0370734");
            byte[] key = ToBytes("2b7e151628aed2a6abf7158809cf4f3c762e7160f38b4da5");
            SetKey(key);
            string result = String.Join("", Encrypt(data).Select(x => x.ToString("x2")));
            Assert.AreEqual("f9fb29aefc384a250340d833b87ebc00", result);
        }

        [Test]
        public void EncryptCase3()
        {
            byte[] data = ToBytes("3243f6a8885a308d313198a2e0370734");
            byte[] key = ToBytes("2b7e151628aed2a6abf7158809cf4f3c762e7160f38b4da56a784d9045190cfe");
            SetKey(key);
            string result = String.Join("", Encrypt(data).Select(x => x.ToString("x2")));
            Assert.AreEqual("1a6e6c2c662e7da6501ffb62bc9e93f3", result);
        }

        [Test]
        public void DecryptCase1()
        {
            byte[] data = ToBytes("3925841d02dc09fbdc118597196a0b32");
            byte[] key = ToBytes("2b7e151628aed2a6abf7158809cf4f3c");
            SetKey(key);
            string result = String.Join("", Decrypt(data).Select(x => x.ToString("x2")));
            Assert.AreEqual("3243f6a8885a308d313198a2e0370734", result);
        }

        [Test]
        public void DecryptCase2()
        {
            byte[] data = ToBytes("f9fb29aefc384a250340d833b87ebc00");
            byte[] key = ToBytes("2b7e151628aed2a6abf7158809cf4f3c762e7160f38b4da5");
            SetKey(key);
            string result = String.Join("", Decrypt(data).Select(x => x.ToString("x2")));
            Assert.AreEqual("3243f6a8885a308d313198a2e0370734", result);
        }

        [Test]
        public void DecryptCase3()
        {
            byte[] data = ToBytes("1a6e6c2c662e7da6501ffb62bc9e93f3");
            byte[] key = ToBytes("2b7e151628aed2a6abf7158809cf4f3c762e7160f38b4da56a784d9045190cfe");
            SetKey(key);
            string result = String.Join("", Decrypt(data).Select(x => x.ToString("x2")));
            Assert.AreEqual("3243f6a8885a308d313198a2e0370734", result);
        }

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

        public byte[] ToBytes(string sIn)
        {
            return sIn
                .Aggregate("", (l, r) => l + ((l.Length + 1) % 3 == 0 ? "," : "") + r)
                .Split(',')
                .Select(x => Convert.ToByte(x, 16))
                .ToArray();
        }
    }
}
