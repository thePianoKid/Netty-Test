package com.solace.nettytest.handlers;

import com.solace.nettytest.data.RequestData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

// Decodes the string message from a byte array to a UTF-8 character sequence
public class RequestDecoder extends ReplayingDecoder<RequestData> {
    private final Charset charset = StandardCharsets.UTF_8;

    @Override
    protected void decode(ChannelHandlerContext context, ByteBuf in, List<Object> out) {
        RequestData data = new RequestData();
        data.setIntValue(in.readInt());
        int strLen = in.readInt();
        data.setStringValue(in.readCharSequence(strLen, charset).toString());
        out.add(data);
    }
}
