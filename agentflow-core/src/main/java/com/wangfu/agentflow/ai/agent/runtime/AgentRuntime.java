package com.wangfu.agentflow.ai.agent.runtime;

import com.wangfu.agentflow.ai.agent.Agent;
import com.wangfu.agentflow.ai.agent.AgentRequest;
import com.wangfu.agentflow.ai.agent.AgentResponse;
import com.wangfu.agentflow.ai.model.ModelInvoker;
import com.wangfu.agentflow.ai.model.ModelOptions;
import com.wangfu.agentflow.ai.model.ModelRouter;
import com.wangfu.agentflow.ai.prompt.PromptContext;
import com.wangfu.agentflow.ai.prompt.PromptManager;
import com.wangfu.agentflow.ai.prompt.PromptRenderer;
import com.wangfu.agentflow.ai.prompt.PromptTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgentRuntime {

    private final PromptManager promptManager;

    private final PromptRenderer promptRenderer;

    private final ModelRouter modelRouter;

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
        ModelOptions modelOptions = agent.getModelOptions();
        if (modelOptions == null) {
            throw new IllegalStateException(
                    "Model options not configured"
            );
        }
        String provider = modelOptions
                .getProvider();
        if (provider == null || provider.isBlank()) {
            throw new IllegalStateException(
                    "Model provider is not configured"
            );
        }
        ModelInvoker invoker = modelRouter.route(provider);
        return invoker.invoke(agent, request, systemContent);
    }
}
