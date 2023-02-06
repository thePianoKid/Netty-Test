package com.solace.nettytest.handlers;

import com.solace.nettytest.data.RequestData;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

// Main handler for Netty client
public class ClientHandler extends ChannelInboundHandlerAdapter {
    // When the client is connected to the server, the client sends the RequestData object to the server
    @Override
    public void channelActive(ChannelHandlerContext context) {
        RequestData msg = new RequestData();
        msg.setIntValue(42);
        msg.setStringValue("Maria");
        ChannelFuture future = context.writeAndFlush(msg);
    }

    // When the response from the server is returned, the contents of the response is printed,
    // then the session is closed
    @Override
    public void channelRead(ChannelHandlerContext context, Object msg) {
        System.out.println(msg);
        context.close();
    }
}
