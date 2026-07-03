package com.wangfu.agentflow.service.impl;

import com.wangfu.agentflow.ai.context.AIContext;
import com.wangfu.agentflow.ai.executor.ChatExecutor;
import com.wangfu.agentflow.response.ChatResponse;
import com.wangfu.agentflow.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatExecutor chatExecutor;

    @Override
    public ChatResponse chat(String message) {
        AIContext context = new AIContext(
                "default-user",
                "default-session",
                "deepseek-chat",
                Locale.CHINA
        );
        String answer = chatExecutor.execute(context, message);
        return ChatResponse.builder()
                .model("")
                .answer(answer)
                .elapsed(0L)
                .promptTokens(0)
                .completionTokens(0)
                .build();
    }
}
