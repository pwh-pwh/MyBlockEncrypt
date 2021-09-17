package com.pwh.entry;

public class BytesBuilder {
    private byte[] bytes;
    private int index;
    private int length;

    public BytesBuilder(int length) {
        this.length = length;
        this.bytes = new byte[length];
        this.index = 0;
    }
    public void append(byte[] bytes1){
        int length = bytes1.length;
        if(index+length> this.length) {
            throw new IllegalArgumentException("长度超过");
        }
        System.arraycopy(bytes1,0,this.bytes,index,length);
        index+=length;
    }

    public byte[] getBytes() {
        return bytes;
    }
}
