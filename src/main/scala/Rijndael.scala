//BEGIN_CHALLENGE
import org.bouncycastle.crypto.engines.AESFastEngine
import org.bouncycastle.crypto.params.KeyParameter
//END_CHALLENGE

class Rijndael extends IRijndael {
  override def encrypt(byte: Array[Byte], key: Array[Byte]): Array[Byte] = {
    //BEGIN_CHALLENGE
    transform(byte, key)
    //END_CHALLENGE
  }

  override def decrypt(byte: Array[Byte], key: Array[Byte]): Array[Byte] = {
    //BEGIN_CHALLENGE
    transform(byte, key, encrypt = false)
    //END_CHALLENGE
  }

  //BEGIN_CHALLENGE
  private def transform(byte: Array[Byte], key: Array[Byte], encrypt: Boolean = true): Array[Byte] = {
    val cipher = new AESFastEngine()
    val buffer: Array[Byte] = new Array(byte.length)

    cipher.init(encrypt, new KeyParameter(key))
    cipher.processBlock(byte, 0, buffer, 0)

    buffer
  }
  //END_CHALLENGE
}
