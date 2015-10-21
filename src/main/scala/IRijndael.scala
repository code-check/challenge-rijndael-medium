trait IRijndael {
  def encrypt(byte: Array[Byte], key: Array[Byte]): Array[Byte]
  def decrypt(byte: Array[Byte], key: Array[Byte]): Array[Byte]
}
