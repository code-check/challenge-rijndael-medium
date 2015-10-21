import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Rijndael implements IRijndael {
    //BEGIN_CHALLENGE
    public byte[] encrypt(byte[] data, byte[] key) {
        try {
            Cipher aes = Cipher.getInstance("AES/ECB/NOPADDING");
            SecretKey sKey = new SecretKeySpec(key, 0, key.length, "AES");
            aes.init(Cipher.ENCRYPT_MODE, sKey);
            return aes.doFinal(data);
        } catch (Exception ex) {
            ex.toString();
        }
        return null;
    }

    public byte[] decrypt(byte[] data, byte[] key) {
        try {
            Cipher aes = Cipher.getInstance("AES/ECB/NOPADDING");
            SecretKey sKey = new SecretKeySpec(key, 0, key.length, "AES");
            aes.init(Cipher.DECRYPT_MODE, sKey);
            return aes.doFinal(data);
        } catch (Exception ex) { }
        return null;
    }
    //END_CHALLENGE
}
