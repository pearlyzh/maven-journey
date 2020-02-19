package com.nghiatn.maven.controller.rpc.dubbo.protobuf;

import com.nghiatn.maven.proto.api.PingRequest;
import com.nghiatn.maven.proto.api.PingResponse;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author nghiatn
 */
public final class HelloDubboServiceProtobuf {

    private static final AtomicBoolean registered = new AtomicBoolean();

    private static Class<?> init() {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(HelloDubboServiceProtobuf.class.getName());
            if (registered.compareAndSet(false, true)) {
                org.apache.dubbo.common.serialize.protobuf.support.ProtobufUtils.marshaller(
                        PingRequest.getDefaultInstance());
                org.apache.dubbo.common.serialize.protobuf.support.ProtobufUtils.marshaller(
                        PingResponse.getDefaultInstance());
            }
        } catch (ClassNotFoundException e) {
            // ignore
        }
        return clazz;
    }

    private HelloDubboServiceProtobuf() {

    }

    /**
     * Code generated for Dubbo
     */
    public interface IHelloDubboServiceProtobuf {
        static Class<?> clazz = init();
        PingResponse setHelloInProtobuf(PingRequest request);
        CompletableFuture<PingResponse> sayHelloAsync(PingRequest request);
    }

}