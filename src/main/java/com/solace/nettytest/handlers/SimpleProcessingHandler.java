package com.solace.nettytest.handlers;

import com.solace.nettytest.data.RequestData;
import com.solace.nettytest.data.ResponseData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SimpleProcessingHandler extends ChannelInboundHandlerAdapter {
    // Stores all inbound bytes
    private ByteBuf tmp;

    // Run when the SimpleProcessingHandler is Added
    @Override
    public void handlerAdded(ChannelHandlerContext context) {
        System.out.println("Handler added");
        // Allocates x number of bytes to the buffer
        tmp = context.alloc().buffer(4);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext context) {
        System.out.println("Handler removed");
        // Garbage collection
        tmp.release();
        tmp = null;
    }

    // Run whenever our Netty instance receives new data
    @Override
    public void channelRead(ChannelHandlerContext context, Object msg) {
        RequestData requestData = (RequestData) msg;
        ResponseData responseData = new ResponseData();
        responseData.setIntValue(requestData.getIntValue() * 2);
        ChannelFuture future = context.writeAndFlush(responseData);
        future.addListener(ChannelFutureListener.CLOSE);
        System.out.println("Request data: " + requestData);
    }
}
