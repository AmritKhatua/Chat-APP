package com.pro.chat.discord_chat_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.pro.chat.discord_chat_backend.entities.Message;
import com.pro.chat.discord_chat_backend.payLoad.MessageRequest;
import com.pro.chat.discord_chat_backend.service.ChatService;

@Controller
@CrossOrigin("https://localhost:3000")
public class ChatController {
    

    @Autowired
    private ChatService chatService;

    //for sending and receiving messages
    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(@RequestBody MessageRequest request, @DestinationVariable String roomId) {
        return chatService.saveMessage(request, roomId);
    }
}
