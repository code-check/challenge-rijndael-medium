package rijndael

import (
	"crypto/aes"
	"crypto/rand"
	"io"
	"testing"
)

func TestEnsureEncrypt(t *testing.T) {
	data := make([]byte, 16)
	key := make([]byte, 16)
	io.ReadFull(rand.Reader, data)
	io.ReadFull(rand.Reader, key)

	block, _ := aes.NewCipher(key)
	exp := make([]byte, len(data))
	block.Encrypt(exp, data)
	act := Encrypt(data, key)

	for i := 0; i < len(exp); i++ {
		if act[i] != exp[i] {
			t.Errorf("found '0x%X' on index '%v' but expected '0x%X'", act[i], i, exp[i])
		}
	}
}

func TestEnsureDecrypt(t *testing.T) {
	data := make([]byte, 16)
	key := make([]byte, 16)
	io.ReadFull(rand.Reader, data)
	io.ReadFull(rand.Reader, key)

	block, _ := aes.NewCipher(key)
	res := make([]byte, len(data))
	block.Encrypt(res, data)
	act := Decrypt(res, key)

	for i := 0; i < len(data); i++ {
		if act[i] != data[i] {
			t.Errorf("found '0x%X' on index '%v' but expected '0x%X'", act[i], i, data[i])
		}
	}
}