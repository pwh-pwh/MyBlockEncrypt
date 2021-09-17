package com.pwh.entry;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
* 块元素
* */
public class Block {
//字节数组
    private final byte[] buffer;

    public int getLength() {
        return length;
    }

    private final int length;

    public byte[] getBuffer() {
        return buffer;
    }

    public Block(byte[] buffer, int length) {
        int bufferLength = buffer.length;
        this.length = length;
        if(bufferLength==0 || length<buffer.length) {
            throw new IllegalArgumentException("参数不合法");
        } else if(bufferLength!=length){
            byte[] bytes = new byte[length];
            System.arraycopy(buffer,0,bytes,0,bufferLength);
            Arrays.fill(bytes,bufferLength,length,(byte)0);
            this.buffer=bytes;
        } else {
            this.buffer=buffer;
        }
    }

    @Override
    public String toString() {
        return "Block{" +
                "buffer=" + Arrays.toString(buffer) +
                ", length=" + length +
                '}';
    }
}
