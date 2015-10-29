package rijndael

import "encoding/hex"
import "testing"

func TestEncrypt1(t *testing.T) {
	key, _ := hex.DecodeString("2b7e151628aed2a6abf7158809cf4f3c")
	data, _ := hex.DecodeString("3243f6a8885a308d313198a2e0370734")
	exp, _ := hex.DecodeString("3925841d02dc09fbdc118597196a0b32")
	act := Encrypt(data, key)
	for i := 0; i < len(exp); i++ {
		if act[i] != exp[i] {
			t.Errorf("found '0x%X' on index '%v' but expected '0x%X'", act[i], i, exp[i])
		}
	}
}

func TestEncrypt2(t *testing.T) {
	key, _ := hex.DecodeString("2b7e151628aed2a6abf7158809cf4f3c762e7160f38b4da5")
	data, _ := hex.DecodeString("3243f6a8885a308d313198a2e0370734")
	exp, _ := hex.DecodeString("f9fb29aefc384a250340d833b87ebc00")
	act := Encrypt(data, key)
	for i := 0; i < len(exp); i++ {
		if act[i] != exp[i] {
			t.Errorf("found '0x%X' on index '%v' but expected '0x%X'", act[i], i, exp[i])
		}
	}
}

func TestEncrypt3(t *testing.T) {
	key, _ := hex.DecodeString("2b7e151628aed2a6abf7158809cf4f3c762e7160f38b4da56a784d9045190cfe")
	data, _ := hex.DecodeString("3243f6a8885a308d313198a2e0370734")
	exp, _ := hex.DecodeString("1a6e6c2c662e7da6501ffb62bc9e93f3")
	act := Encrypt(data, key)
	for i := 0; i < len(exp); i++ {
		if act[i] != exp[i] {
			t.Errorf("found '0x%X' on index '%v' but expected '0x%X'", act[i], i, exp[i])
		}
	}
}

func TestDecrypt1(t *testing.T) {
	key, _ := hex.DecodeString("2b7e151628aed2a6abf7158809cf4f3c")
	exp, _ := hex.DecodeString("3243f6a8885a308d313198a2e0370734")
	data, _ := hex.DecodeString("3925841d02dc09fbdc118597196a0b32")
	act := Decrypt(data, key)
	for i := 0; i < len(exp); i++ {
		if act[i] != exp[i] {
			t.Errorf("found '0x%X' on index '%v' but expected '0x%X'", act[i], i, exp[i])
		}
	}
}

func TestDecrypt2(t *testing.T) {
	key, _ := hex.DecodeString("2b7e151628aed2a6abf7158809cf4f3c762e7160f38b4da5")
	exp, _ := hex.DecodeString("3243f6a8885a308d313198a2e0370734")
	data, _ := hex.DecodeString("f9fb29aefc384a250340d833b87ebc00")
	act := Decrypt(data, key)
	for i := 0; i < len(exp); i++ {
		if act[i] != exp[i] {
			t.Errorf("found '0x%X' on index '%v' but expected '0x%X'", act[i], i, exp[i])
		}
	}
}

func TestDecrypt3(t *testing.T) {
	key, _ := hex.DecodeString("2b7e151628aed2a6abf7158809cf4f3c762e7160f38b4da56a784d9045190cfe")
	exp, _ := hex.DecodeString("3243f6a8885a308d313198a2e0370734")
	data, _ := hex.DecodeString("1a6e6c2c662e7da6501ffb62bc9e93f3")
	act := Decrypt(data, key)
	for i := 0; i < len(exp); i++ {
		if act[i] != exp[i] {
			t.Errorf("found '0x%X' on index '%v' but expected '0x%X'", act[i], i, exp[i])
		}
	}
}