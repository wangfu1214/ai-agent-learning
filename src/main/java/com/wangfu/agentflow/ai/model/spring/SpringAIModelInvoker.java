package com.wangfu.agentflow.ai.model.spring;

import com.wangfu.agentflow.ai.agent.Agent;
import com.wangfu.agentflow.ai.agent.AgentRequest;
import com.wangfu.agentflow.ai.agent.AgentResponse;
import com.wangfu.agentflow.ai.model.ModelInvoker;
import com.wangfu.agentflow.ai.model.ModelOptions;
import com.wangfu.agentflow.ai.model.ModelResolver;
import com.wangfu.agentflow.ai.tool.registry.ToolRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class SpringAIModelInvoker implements ModelInvoker {

    private final ChatClientProvider chatClientProvider;

    private final ToolRegistry toolRegistry;

    private final ModelResolver modelResolver;

    @Override
    public AgentResponse invoke(Agent agent, AgentRequest request, String systemPrompt) {
        String model = modelResolver.resolveModel(agent, request);
        ChatClient chatClient = chatClientProvider.get(model);
        String answer = chatClient
                .prompt()
                .system(systemPrompt)
                .user(request.getUserMessage())
                .tools(toolRegistry.getAllTools())
                .call()
                .content();

        return AgentResponse.builder()
                .answer(answer)
                .model(model)
                .success(true)
                .build();
    }
}
