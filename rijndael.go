package rijndael
//BEGIN_CHALLENGE
import "crypto/aes"
//END_CHALLENGE

func Encrypt(data []byte, key []byte) []byte {
//BEGIN_CHALLENGE
	block, _ := aes.NewCipher(key)
	ciphertext := make([]byte, len(data))
	block.Encrypt(ciphertext, data)
	return ciphertext
//END_CHALLENGE
	return data
}

func Decrypt(data []byte, key []byte) []byte {
//BEGIN_CHALLENGE
	block, _ := aes.NewCipher(key)
	ciphertext := make([]byte, len(data))
	block.Decrypt(ciphertext, data)
	return ciphertext
//END_CHALLENGE
	return data
}