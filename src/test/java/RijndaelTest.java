import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

public class RijndaelTest extends Rijndael {
    private final byte[] bEnc = new byte[] { 0x32, 0x43, (byte)0xf6, (byte)0xa8, (byte)0x88, 0x5a, 0x30, (byte)0x8d, 0x31, 0x31, (byte)0x98, (byte)0xa2, (byte)0xe0, 0x37, 0x07, 0x34 };
    private final byte[] bCase1 = new byte[] { 0x39, 0x25, (byte)0x84, 0x1d, 0x02, (byte)0xdc, 0x09, (byte)0xfb, (byte)0xdc, 0x11, (byte)0x85, (byte)0x97, 0x19, 0x6a, 0x0b, 0x32 };
    private final byte[] bCase2 = new byte[] { (byte)0xf9, (byte)0xfb, 0x29, (byte)0xae, (byte)0xfc, 0x38, 0x4a, 0x25, 0x03, 0x40, (byte)0xd8, 0x33, (byte)0xb8, 0x7e, (byte)0xbc, 0x00 };
    private final byte[] bCase3 = new byte[] { 0x1a, 0x6e, 0x6c, 0x2c, 0x66, 0x2e, 0x7d, (byte)0xa6, 0x50, 0x1f, (byte)0xfb, 0x62, (byte)0xbc, (byte)0x9e, (byte)0x93, (byte)0xf3 };
    private final byte[] bKey1 = new byte[] { 0x2b, 0x7e, 0x15, 0x16, 0x28, (byte)0xae, (byte)0xd2, (byte)0xa6, (byte)0xab, (byte)0xf7, 0x15, (byte)0x88, 0x09, (byte)0xcf, 0x4f, 0x3c };
    private final byte[] bKey2 = new byte[] { 0x2b, 0x7e, 0x15, 0x16, 0x28, (byte)0xae, (byte)0xd2, (byte)0xa6, (byte)0xab, (byte)0xf7, 0x15, (byte)0x88, 0x09, (byte)0xcf, 0x4f, 0x3c, 0x76, 0x2e, 0x71, 0x60, (byte)0xf3, (byte)0x8b, 0x4d, (byte)0xa5};
    private final byte[] bKey3 = new byte[] { 0x2b, 0x7e, 0x15, 0x16, 0x28, (byte)0xae, (byte)0xd2, (byte)0xa6, (byte)0xab, (byte)0xf7, 0x15, (byte)0x88, 0x09, (byte)0xcf, 0x4f, 0x3c, 0x76, 0x2e, 0x71, 0x60, (byte)0xf3, (byte)0x8b, 0x4d, (byte)0xa5, 0x6a, 0x78, 0x4d, (byte)0x90, 0x45, 0x19, 0x0c, (byte)0xfe };

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
    public void encryptCase1() {
        Assert.assertArrayEquals(encrypt(bEnc, bKey1), bCase1);
    }

    @Test
    public void encryptCase2() {
        Assert.assertArrayEquals(encrypt(bEnc, bKey2), bCase2);
    }

    @Test
    public void encryptCase3() {
        Assert.assertArrayEquals(encrypt(bEnc, bKey3), bCase3);
    }

    @Test
    public void decryptCase1() {
        Assert.assertArrayEquals(decrypt(bCase1, bKey1), bEnc);
    }

    @Test
    public void decryptCase2()  {
        Assert.assertArrayEquals(decrypt(bCase2, bKey2), bEnc);
    }

    @Test
    public void decryptCase3()  {
        Assert.assertArrayEquals(decrypt(bCase3, bKey3), bEnc);
    }
}
