package com.solace.nettytest.handlers;

import com.solace.nettytest.data.ResponseData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

// Decodes the response from the server and adds the Java object to the response list
public class ResponseDataDecoder extends ReplayingDecoder<ResponseData> {
    @Override
    protected void decode(ChannelHandlerContext context, ByteBuf in, List<Object> out) {
        ResponseData data = new ResponseData();
        data.setIntValue(in.readInt());
        out.add(data);
    }
}
