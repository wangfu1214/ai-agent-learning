package com.wangfu.agentflow.ai.executor;

import com.wangfu.agentflow.ai.context.AIContext;
import com.wangfu.agentflow.ai.registry.ToolRegistry;
import com.wangfu.agentflow.ai.prompt.PromptManager;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatExecutor {

    private final ChatClient chatClient;

    private final PromptManager promptManager;

    private final ToolRegistry toolRegistry;

    public String execute(AIContext content, String message) {
        return chatClient
                .prompt()
                .system(promptManager.systemPrompt())
                .user(message)
                .tools(toolRegistry.getAllTools())
                .call()
                .content();
    }
}
