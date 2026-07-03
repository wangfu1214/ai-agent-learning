package com.wangfu.week01_chat.service.impl;

import com.wangfu.week01_chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatClient chatClient;

    @Override
    public String chat(String message) {
        return chatClient.prompt(message).call().content();
    }
}
