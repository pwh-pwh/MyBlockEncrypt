package com.pwh.mode;

import com.pwh.cipher.MyCipher;
import com.pwh.entry.Block;
import com.pwh.entry.BytesBuilder;

public class ECB extends CipherMode{

    public ECB(MyCipher myCipher, int length) {
        super(myCipher, length);
    }

    @Override
    public byte[] encode(byte[] bytes) {
        MyCipher myCipher = getMyCipher();
        Block[] blocks = getBlocks(bytes);
        BytesBuilder bytesBuilder = new BytesBuilder(blocks.length*getLength());
        for (Block block : blocks) {
            byte[] encrypt = myCipher.encrypt(block);
            bytesBuilder.append(encrypt);
        }
        return bytesBuilder.getBytes();
    }
}
