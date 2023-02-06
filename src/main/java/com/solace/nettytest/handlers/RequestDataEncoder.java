package com.solace.nettytest.handlers;

import com.solace.nettytest.data.RequestData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

// Encodes the request so that it can be sent to the Netty server
public class RequestDataEncoder extends MessageToByteEncoder<RequestData> {
    private final Charset charset = StandardCharsets.UTF_8;

    @Override
    protected void encode(ChannelHandlerContext context, RequestData msg, ByteBuf out) {
        out.writeInt(msg.getIntValue());
        out.writeInt(msg.getStringValue().length());
        out.writeCharSequence(msg.getStringValue(), charset);
    }
}
