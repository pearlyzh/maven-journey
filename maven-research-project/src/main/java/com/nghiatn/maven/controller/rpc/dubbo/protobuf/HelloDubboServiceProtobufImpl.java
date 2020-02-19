package com.nghiatn.maven.controller.rpc.dubbo.protobuf;

import com.nghiatn.maven.proto.api.PingRequest;
import com.nghiatn.maven.proto.api.PingResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.CompletableFuture;

/**
 * @author nghiatn
 */

@Service(version = "1.0.1")
@Slf4j
public class HelloDubboServiceProtobufImpl implements HelloDubboServiceProtobuf.IHelloDubboServiceProtobuf {
    @Override
    public PingResponse setHelloInProtobuf(PingRequest request) {
        log.info("Hello " + request.getRequest() + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return PingResponse.newBuilder()
                .setResponse("Hello " + request.getRequest() + ", response from provider: "
                        + RpcContext.getContext().getLocalAddress()).setReturncode(1).build();
    }


    @Override
    public CompletableFuture<PingResponse> sayHelloAsync(PingRequest request) {
        return CompletableFuture.completedFuture(setHelloInProtobuf(request));
    }
}
