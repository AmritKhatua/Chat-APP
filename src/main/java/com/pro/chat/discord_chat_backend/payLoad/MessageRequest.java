package com.pro.chat.discord_chat_backend.payLoad;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {
    
    private String sender;
    private String roomId;
    private String content;
    
   
}
