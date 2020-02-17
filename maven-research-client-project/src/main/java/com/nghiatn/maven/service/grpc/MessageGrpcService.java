package com.nghiatn.maven.service.grpc;

import com.nghiatn.maven.entity.MessageEntity;
import com.nghiatn.maven.proto.api.PingGRpcServiceGrpc;
import com.nghiatn.maven.proto.api.PingRequest;
import com.nghiatn.maven.proto.api.PingResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author nghiatn
 */

@Service
@Slf4j
public class MessageGrpcService {

    @Value("${server-research.grpc.host}")
    private String host;
    @Value("${server-research.grpc.port}")
    private int serverPort;

    public String grpcPingMessage(MessageEntity messageEntity) {
        ManagedChannel channel = null;
        try {
            channel = ManagedChannelBuilder.forAddress(host, serverPort)
                    .usePlaintext()
                    .build();


            PingGRpcServiceGrpc.PingGRpcServiceBlockingStub stub = PingGRpcServiceGrpc.newBlockingStub(channel);

            PingResponse response = stub.ping(
                    PingRequest.newBuilder()
                    .setRequest(messageEntity.getContent())
                    .build());

            return response.getResponse();
        } catch (Exception e) {
            log.error("grpcPingMessage failed: " + e.getMessage(), e);
            return e.getMessage();
        } finally {
            if (channel != null) {
                channel.shutdown();
            }

        }

    }

    @Override
    protected void finalize() throws Throwable {

    }
}
