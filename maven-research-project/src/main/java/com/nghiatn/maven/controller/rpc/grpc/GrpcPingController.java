package com.nghiatn.maven.controller.rpc.grpc;

import com.nghiatn.maven.entity.MessageEntity;
import com.nghiatn.maven.proto.api.PingGRpcServiceGrpc;
import com.nghiatn.maven.proto.api.PingRequest;
import com.nghiatn.maven.proto.api.PingResponse;
import com.nghiatn.maven.repository.MessageRepository;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author nghiatn
 */

@GRpcService
@Slf4j
public class GrpcPingController extends PingGRpcServiceGrpc.PingGRpcServiceImplBase {
    @Autowired
    MessageRepository messageRepository;

    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {
        log.info("Request: " + request.getRequest());

        MessageEntity messageEntity = MessageEntity.builder().content(request.getRequest()).build();
        messageRepository.save(messageEntity);

        responseObserver.onNext(PingResponse.newBuilder()
                .setResponse(request.getRequest() + "-ServerHandled!")
                .setReturncode(1)
                .build());
        responseObserver.onCompleted();
    }
}
