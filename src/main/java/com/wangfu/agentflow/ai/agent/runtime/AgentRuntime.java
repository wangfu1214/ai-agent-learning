package com.wangfu.agentflow.ai.agent.runtime;

import com.wangfu.agentflow.ai.agent.Agent;
import com.wangfu.agentflow.ai.agent.AgentRequest;
import com.wangfu.agentflow.ai.agent.AgentResponse;
import com.wangfu.agentflow.ai.model.ModelInvoker;
import com.wangfu.agentflow.ai.model.spring.SpringAIModelInvoker;
import com.wangfu.agentflow.ai.prompt.PromptContext;
import com.wangfu.agentflow.ai.prompt.PromptManager;
import com.wangfu.agentflow.ai.prompt.PromptRenderer;
import com.wangfu.agentflow.ai.prompt.PromptTemplate;
import com.wangfu.agentflow.ai.tool.registry.ToolRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgentRuntime {

    private final PromptManager promptManager;

    private final PromptRenderer promptRenderer;

    private final ModelInvoker modelInvoker;

    public AgentResponse run(Agent agent, AgentRequest request) {

        PromptTemplate promptTemplate = promptManager.get(agent.getSystemPromptName());

        if (promptTemplate == null) {
            throw new IllegalStateException(
                    "Prompt not found: " + agent.getSystemPromptName()
            );
        }

        PromptContext context = PromptContext.builder()
                .promptTemplate(promptTemplate)
                .userMessage(request.getUserMessage())
                .promptVariables(request.getPromptContext() == null
                        ? null
                        : request.getPromptContext().getPromptVariables())
                .build();

        String systemContent = promptRenderer.render(context);

        return modelInvoker.invoke(agent, request, systemContent);
    }
}
