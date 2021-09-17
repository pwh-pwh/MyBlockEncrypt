package com.pwh.mode;

import com.pwh.cipher.MyCipher;
import com.pwh.entry.Block;
import com.pwh.entry.BytesBuilder;
import com.pwh.utils.MyByteUtil;

import java.util.Random;

public class CTR extends CipherMode{
    public CTR(MyCipher myCipher, int length) {
        super(myCipher, length);
    }

    @Override
    public byte[] encode(byte[] bytes) {
        MyCipher myCipher = getMyCipher();
        Block[] blocks = getBlocks(bytes);
        int length = getLength();
        byte[] count = MyByteUtil.getRandomByte(length);
        BytesBuilder bytesBuilder = new BytesBuilder(length * blocks.length);
        for (int i = 0; i < blocks.length; i++) {
            byte[] encrypt = myCipher.encrypt(new Block(count, length));
            byte[] xor = MyByteUtil.xor(encrypt, blocks[i].getBuffer());
            bytesBuilder.append(xor);
            increaseCount(count);
        }

        return new byte[0];
    }
    public void increaseCount(byte[] bytes) {
        int length = bytes.length;
        if(bytes[length-1]==0b01111111) {
            bytes[length-1] = 0;
            for (int i = length-2; i >= 0 ; i--) {
                if(bytes[i]==0b01111111){
                    bytes[i] = 0;
                }else {
                    bytes[i]+=1;
                    break;
                }
            }
        }else {
            bytes[length-1] +=1;
        }
    }
}
