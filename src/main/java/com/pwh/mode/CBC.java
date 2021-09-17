package com.pwh.mode;

import com.pwh.cipher.MyCipher;
import com.pwh.entry.Block;
import com.pwh.entry.BytesBuilder;
import com.pwh.utils.MyByteUtil;

public class CBC extends CipherMode{


    public CBC(MyCipher myCipher, int length) {
        super(myCipher, length);
    }


    @Override
    public byte[] encode(byte[] bytes) {
        int length = getLength();
        MyCipher myCipher = getMyCipher();
        Block[] blocks = getBlocks(bytes);
        byte[] randomOriginKey = MyByteUtil.getRandomByte(length);
        BytesBuilder bytesBuilder = new BytesBuilder(blocks.length * getLength());
        for (int i = 0; i < blocks.length; i++) {
            byte[] xor = MyByteUtil.xor(randomOriginKey, blocks[i].getBuffer());
            byte[] encrypt = myCipher.encrypt(new Block(xor, length));
            bytesBuilder.append(encrypt);
            randomOriginKey = encrypt;
        }
        return bytesBuilder.getBytes();
    }
}
