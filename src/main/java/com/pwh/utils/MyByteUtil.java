package com.pwh.utils;


import java.util.Random;

public class MyByteUtil {
    public static byte[] getRandomByte(int length) {
        byte[] bytes = new byte[length];
        new Random().nextBytes(bytes);
        return bytes;
    }
    public static byte[] xor(byte[] b1,byte[] b2) {
        if(b1.length!=b2.length||b1.length==0) {
            throw new IllegalArgumentException("参数不合法");
        }else {
            int length = b1.length;
            byte[] resultBytes = new byte[length];
            for (int i = 0; i < length; i++) {
                resultBytes[i] =(byte)(b1[i]^b2[i]);
            }
            return resultBytes;
        }
    }
}
