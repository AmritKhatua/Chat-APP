package com.pro.chat.discord_chat_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pro.chat.discord_chat_backend.entities.Room;


public interface RoomRepo extends MongoRepository<Room,String> {

    //get room using room id
    Room  findByRoomId(String roomId);

    
}
