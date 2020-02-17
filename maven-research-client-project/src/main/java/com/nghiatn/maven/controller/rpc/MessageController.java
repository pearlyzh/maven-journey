package com.nghiatn.maven.controller.rpc;


import com.nghiatn.maven.controller.dto.BaseResponse;
import com.nghiatn.maven.entity.MessageEntity;
import com.nghiatn.maven.repository.MessageRepository;
import com.nghiatn.maven.service.ClientMessageService;
import com.nghiatn.maven.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/message")
@Slf4j
public class MessageController {

    @Autowired
    ClientMessageService messageService;

    @PostMapping(value = "/addnew")
    public String ping(@RequestParam("content") String message) {
        log.info("Request data: " + message);

        MessageEntity messageEntity = MessageEntity.builder().content(message).build();

        BaseResponse response = messageService.handleAddNewMessage(messageEntity);

        return JsonUtils.printGson(response);
    }
}
