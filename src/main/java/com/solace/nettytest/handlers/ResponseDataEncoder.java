package com.solace.nettytest.handlers;

import com.solace.nettytest.data.ResponseData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class ResponseDataEncoder extends MessageToByteEncoder<ResponseData> {
    @Override
    protected void encode(ChannelHandlerContext context, ResponseData msg, ByteBuf out) {
        out.writeInt(msg.getIntValue());
    }
}
