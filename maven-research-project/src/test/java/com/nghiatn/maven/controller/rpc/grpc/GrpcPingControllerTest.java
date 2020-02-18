package com.nghiatn.maven.controller.rpc.grpc;

import com.nghiatn.maven.GrpcTestApp;
import com.nghiatn.maven.entity.MessageEntity;
import com.nghiatn.maven.proto.api.PingGRpcServiceGrpc;
import com.nghiatn.maven.proto.api.PingRequest;
import com.nghiatn.maven.proto.api.PingResponse;
import com.nghiatn.maven.repository.MessageRepository;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

/**
 * @author nghiatn
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GrpcTestApp.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE, properties = {
//        "grpc.enabled=false",
//        "grpc.inProcessServerName='grpcTestServer'"
})
public class GrpcPingControllerTest extends GrpcServerTestBase {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        // GIVEN
        PingGRpcServiceGrpc.PingGRpcServiceBlockingStub stub = PingGRpcServiceGrpc.newBlockingStub(Optional.ofNullable(channel).orElse(inProcChannel));

        // WHEN
        PingResponse response = stub.ping(PingRequest.newBuilder().build());

        // THEN
        assertThat(response.getResponse(), Is.is("-ServerHandled!"));
        assertThat(response.getReturncode(), Is.is(1));
    }

}