package com.pwh.cipher;

import com.pwh.entry.Block;

import java.util.Arrays;

public class Caesar extends MyCipher{
    @Override
    public byte[] encrypt(Block block) {
        byte[] keyBytes = getKey();
        byte[] buffer = block.getBuffer();
        byte[] bytes = null;
        try{
            int key = Integer.parseInt(new String(keyBytes));
            bytes = Arrays.copyOf(buffer, buffer.length);
            for (int i = 0; i < buffer.length; i++) {
                bytes[i]+=key;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            return bytes;
        }

    }

    public byte[] decrypt(Block block) {
        byte[] keyBytes = getKey();
        byte[] buffer = block.getBuffer();
        byte[] bytes = null;
        try{
            int key = Integer.parseInt(new String(keyBytes));
            bytes = Arrays.copyOf(buffer, buffer.length);
            for (int i = 0; i < buffer.length; i++) {
                bytes[i]-=key;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            return bytes;
        }
    }
}
