package com.heanes.utils.core.lang;

/**
 * long与byte之间的转换
 *
 * @author Heanes
 * @time 2020-06-27 10:48:19 周六
 */
public class LongAndByte {

    public static byte[] longToByte(long l) {
        byte[] b = new byte[8];
        for (int i = 0; i < 8; i++) {
            b[i] = (byte) ((l >> (i * 8)) & 0xff);
        }
        return b;
    }

    public static long byteToLong(byte[] b) {
        long l = 0L;
        for (int i = 0; i < 8; i++) {
            l |= (long)(b[i] & 0xff) << (i * 8);
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(0xaabbff11L + " " + longToByte(0xaabbff11L) + " " + byteToLong(longToByte(0xaabbff11L)));
    }
}
