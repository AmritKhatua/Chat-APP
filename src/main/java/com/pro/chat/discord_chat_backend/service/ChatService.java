package com.pro.chat.discord_chat_backend.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.chat.discord_chat_backend.entities.Message;
import com.pro.chat.discord_chat_backend.entities.Room;
import com.pro.chat.discord_chat_backend.payLoad.MessageRequest;
import com.pro.chat.discord_chat_backend.repository.RoomRepo;

@Service
public class ChatService {
    
    @Autowired
    private RoomRepo roomRepo;

    public Message saveMessage(MessageRequest request, String roomId) {
        Room room = roomRepo.findByRoomId(roomId);
        if (room == null) {
            throw new RuntimeException("Room not found!");
        }

        Message message = new Message(request.getSender(), request.getContent());
        message.setTimeStamp(LocalDateTime.now());
        room.getMessages().add(message);
        roomRepo.save(room);

        return message;
    }
}
