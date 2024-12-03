package com.pro.chat.discord_chat_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.chat.discord_chat_backend.entities.Message;
import com.pro.chat.discord_chat_backend.entities.Room;
import com.pro.chat.discord_chat_backend.repository.RoomRepo;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepo roomRepo;

    public Room createRoom(String roomId) {
        if (roomRepo.findByRoomId(roomId) != null) {
            throw new RuntimeException("Room already exists!");
        }
        Room room = new Room();
        room.setRoomId(roomId);
        return roomRepo.save(room);
    }

    public Room getRoomByRoomId(String roomId) {
        Room room = roomRepo.findByRoomId(roomId);
        if (room == null) {
            throw new RuntimeException("Room not found!");
        }
        return room;
    }

    public List<Message> getMessages(String roomId, int page, int size) {
        Room room = roomRepo.findByRoomId(roomId);
        if (room == null) {
            throw new RuntimeException("Room not found!");
        }

        List<Message> messages = room.getMessages();
        int start = Math.max(0, messages.size() - (page + 1) * size);
        int end = Math.min(messages.size(), start + size);
        return messages.subList(start, end);
    }
}
