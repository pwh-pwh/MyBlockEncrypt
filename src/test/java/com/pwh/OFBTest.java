package com.pwh;

import com.pwh.cipher.Caesar;
import com.pwh.mode.CBC;
import com.pwh.mode.OFB;

public class OFBTest {
    public static void main(String[] args) {
        Caesar caesar = new Caesar();
        caesar.init("3".getBytes());
        byte[] encode = new OFB(caesar, 8).encode("hello world".getBytes());
        System.out.println(encode);
    }
}
