package com.pwh;

import com.pwh.cipher.Caesar;
import com.pwh.entry.Block;

public class CaesarTest {
    public static void main(String[] args) {
        Caesar caesar = new Caesar();
        byte[] keyBytes = "3".getBytes();
        String str = "Hello World";
        Block block = new Block(str.getBytes(), 64);
        caesar.init(keyBytes);
        System.out.println(caesar.encrypt(block).toString());
        System.out.println(new String(caesar.decrypt(new Block(caesar.encrypt(block),64))).toString());
    }
}
