package com.nghiatn.maven.service;

import com.nghiatn.maven.controller.dto.BaseResponse;
import com.nghiatn.maven.entity.MessageEntity;
import com.nghiatn.maven.repository.MessageRepository;
import com.nghiatn.maven.service.grpc.MessageGrpcService;
import com.nghiatn.maven.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nghiatn
 */
@Service
@Slf4j
public class ClientMessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    MessageGrpcService messageGrpcService;

    public BaseResponse handleAddNewMessage(MessageEntity messageEntity) {
        log.info("Handling: " + JsonUtils.printGson(messageEntity));
        messageRepository.save(messageEntity);
        log.info("SendGRPC: " + messageEntity.getContent());

        String resp = messageGrpcService.grpcPingMessage(messageEntity);

        return BaseResponse.builder().returnCode(1).returnMessage(resp).build();
    }

}
