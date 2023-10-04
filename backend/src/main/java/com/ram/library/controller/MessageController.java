package com.ram.library.controller;

import com.ram.library.entity.Message;
import com.ram.library.requestmodel.AdminQuestionRequest;
import com.ram.library.service.MessageService;
import com.ram.library.utils.ExtractJwt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;
    private static final Logger LOG = LoggerFactory.getLogger(MessageController.class);


    @PostMapping("/secure/add/message")
    public void postMessages(@RequestHeader(value = "Authorization") String token, @RequestBody Message messageRequest) {
        String userEmail = ExtractJwt.payLoadJwtExtraction(token, "\"sub\"");
        LOG.info("Inside add message");

        messageService.postMessage(messageRequest, userEmail);
    }

    @PutMapping("/secure/admin/message")
    public void putMessages(@RequestHeader(value = "Authorization") String token, @RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception {
        String userEmail = ExtractJwt.payLoadJwtExtraction(token,"\"sub\"");
        String admin = ExtractJwt.payLoadJwtExtraction(token,"\"userType\"");
        if(admin == null || !admin.equals(admin)){
            throw new Exception("Administration Page only");
        }
        messageService.putMessage(adminQuestionRequest,userEmail);
    }

}
