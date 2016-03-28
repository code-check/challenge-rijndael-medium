import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Field;
import java.util.Random;

public class RijndaelRandomTest extends Rijndael {
    @Before
    public void init() {
        try {
            // "Unlimited Strength" hack, support for 192 & 256 bit keys
            Field field = Class.forName("javax.crypto.JceSecurity").getDeclaredField("isRestricted");
            field.setAccessible(true);
            field.set(null, java.lang.Boolean.FALSE);
        } catch (Exception ex) { }
    }

    @Test
    public void checkInterface() {
        Assert.assertTrue("The Rijndael should implement the IRijndael interface", this instanceof IRijndael);
    }

    @Test
    public void checkRandom() {
        Random rand = new Random();
        byte[] key = new byte[32];
        byte[] block = new byte[16];
        byte[] original;
        for (int i = 0; i < 10; i++) {
            rand.nextBytes(block);
            rand.nextBytes(key);
            original = block.clone();
            Assert.assertArrayEquals(original, decrypt(encrypt(block, key), key));
        }
    }

    @Test
    public void assertCipher() {
        try {
            Cipher aes = Cipher.getInstance("AES/ECB/NOPADDING");
            Random rand = new Random();
            byte[] key = new byte[32];
            byte[] block = new byte[16];
            byte[] original;
            for (int i = 0; i < 10; i++) {
                rand.nextBytes(block);
                rand.nextBytes(key);
                original = block.clone();

                SecretKey sKey = new SecretKeySpec(key, 0, key.length, "AES");
                aes.init(Cipher.ENCRYPT_MODE, sKey);
                Assert.assertArrayEquals(aes.doFinal(original), encrypt(block, key));
            }
        } catch (Exception ex) { }
    }
}
