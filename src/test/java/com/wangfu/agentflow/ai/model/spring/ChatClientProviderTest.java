package com.wangfu.agentflow.ai.model.spring;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ChatClientProviderTest {

    @Test
    void shouldReturnDefaultChatClient() {
        ChatClient chatClient = mock(ChatClient.class);
        ChatClientProvider provider = new ChatClientProvider(chatClient);

        ChatClient result = provider.get("deepseek-chat");

        assertSame(chatClient, result);
    }
}