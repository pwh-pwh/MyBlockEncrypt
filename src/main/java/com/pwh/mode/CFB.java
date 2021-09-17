package com.pwh.mode;

import com.pwh.cipher.MyCipher;
import com.pwh.entry.Block;
import com.pwh.entry.BytesBuilder;
import com.pwh.utils.MyByteUtil;

import java.util.Arrays;

public class CFB extends CipherMode{
    public CFB(MyCipher myCipher, int length) {
        super(myCipher, length);
    }

    @Override
    public byte[] encode(byte[] bytes) {
        MyCipher myCipher = getMyCipher();
        Block[] blocks = getBlocks(bytes);
        BytesBuilder bytesBuilder = new BytesBuilder(getLength() * blocks.length);
        byte[] randomByte = MyByteUtil.getRandomByte(getLength()*2);

        for (int i = 0; i < blocks.length; i++) {
            byte[] encrypt = myCipher.encrypt(new Block(randomByte, randomByte.length));
            byte[] beforeByte = Arrays.copyOfRange(encrypt,0,getLength());
            byte[] endByte = Arrays.copyOfRange(encrypt,getLength(),getLength()*2);
            byte[] xor = MyByteUtil.xor(endByte, blocks[i].getBuffer());
            endByte = beforeByte;
            beforeByte = xor;
            bytesBuilder.append(xor);
            System.arraycopy(beforeByte,0,randomByte,0,getLength());
            System.arraycopy(endByte,0,randomByte,getLength(),getLength());


        }
        return bytesBuilder.getBytes();
    }
}
