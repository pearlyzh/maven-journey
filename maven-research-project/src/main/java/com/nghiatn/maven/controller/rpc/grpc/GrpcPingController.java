package com.nghiatn.maven.controller.rpc.grpc;

import com.nghiatn.maven.proto.api.PingGRpcServiceGrpc;
import com.nghiatn.maven.proto.api.PingRequest;
import com.nghiatn.maven.proto.api.PingResponse;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

/**
 * @author nghiatn
 */

@GRpcService
public class GrpcPingController extends PingGRpcServiceGrpc.PingGRpcServiceImplBase {
    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {
        responseObserver.onNext(PingResponse.newBuilder()
                .setResponse("pong")
                .build());
        responseObserver.onCompleted();
    }
}
