package com.pwh.cipher;

import com.pwh.entry.Block;

import javax.crypto.Cipher;

public abstract class MyCipher{
    private byte[] key;
    public abstract byte[] encrypt(Block block);
    public abstract byte[] decrypt(Block block);
    public void init(byte[] key){
        this.key = key;
    }

    public byte[] getKey() {
        return key;
    }
}
