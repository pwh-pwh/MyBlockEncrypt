package com.pwh;

import com.pwh.cipher.Caesar;
import com.pwh.mode.CBC;

public class CBCTest {
    public static void main(String[] args) {
        Caesar caesar = new Caesar();
        caesar.init("3".getBytes());
        byte[] encode = new CBC(caesar, 8).encode("hello world".getBytes());
        System.out.println(encode);
    }
}
