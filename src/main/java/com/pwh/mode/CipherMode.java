package com.pwh.mode;

import com.pwh.cipher.MyCipher;
import com.pwh.entry.Block;

import java.util.Arrays;

public abstract class CipherMode {
//    分块长度
    private final int length;
    private Block[] blocks;
    private final MyCipher myCipher;

    public int getLength() {
        return length;
    }

    public MyCipher getMyCipher() {
        return myCipher;
    }

    public CipherMode(MyCipher myCipher, int length) {
        this.myCipher = myCipher;
        this.length = length;
    }
    protected Block[] getBlocks(byte[] bytes) {
        int blockLength = bytes.length / length +(bytes.length%length==0?0:1);
        this.blocks = new Block[blockLength];
        int currentIndex = 0;
        for (int i = 0; i < blockLength; i++) {
            blocks[i] = new Block(Arrays.copyOfRange(bytes,currentIndex,currentIndex+length),length);
            currentIndex+=length;
        }
        return blocks;
    }
    public abstract byte[] encode(byte[] bytes);
}
