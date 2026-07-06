package com.wangfu.agentflow.service.impl;

import com.wangfu.agentflow.ai.agent.AgentRequest;
import com.wangfu.agentflow.ai.agent.AgentResponse;
import com.wangfu.agentflow.ai.context.AIContext;
import com.wangfu.agentflow.ai.agent.AgentExecutor;
import com.wangfu.agentflow.response.ChatResponse;
import com.wangfu.agentflow.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final AgentExecutor agentExecutor;

    @Override
    public ChatResponse chat(String message) {
        AgentRequest request = AgentRequest.builder()
                .userMessage(message)
                .build();
        AgentResponse response = agentExecutor.execute("default-agent", request);
        return ChatResponse.builder()
                .model("")
                .answer(response.getAnswer())
                .elapsed(0L)
                .promptTokens(0)
                .completionTokens(0)
                .build();
    }
}
