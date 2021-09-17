package com.pwh;

import com.pwh.cipher.Caesar;
import com.pwh.mode.ECB;

public class ECBTest {
    public static void main(String[] args) {
        Caesar caesar = new Caesar();
        caesar.init("3".getBytes());
        byte[] encode = new ECB(caesar, 8).encode("hello world".getBytes());
        System.out.println(encode);
    }
}
