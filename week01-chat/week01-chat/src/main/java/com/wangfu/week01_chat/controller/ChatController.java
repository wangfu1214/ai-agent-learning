package com.wangfu.week01_chat.controller;

import com.wangfu.week01_chat.response.ChatResponse;
import com.wangfu.week01_chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ai/chat")
public class ChatController {

    private final ChatService chatService;

    @GetMapping
    public ChatResponse chat(@RequestParam String message) {
        return chatService.chat(message);
    }
}
