package com.wangfu.agentflow.ai.agent;

import com.wangfu.agentflow.ai.prompt.PromptContext;
import com.wangfu.agentflow.ai.prompt.PromptRenderer;
import com.wangfu.agentflow.ai.prompt.PromptTemplate;
import com.wangfu.agentflow.ai.tool.registry.ToolRegistry;
import com.wangfu.agentflow.ai.prompt.PromptManager;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgentExecutor {

    private final ChatClient chatClient;

    private final PromptManager promptManager;

    private final ToolRegistry toolRegistry;

    private final PromptRenderer promptRenderer;

    public AgentResponse execute(Agent agent, AgentRequest request) {
        try {
            PromptTemplate promptTemplate = promptManager.get(agent.getSystemPromptName());

            if (promptTemplate == null) {
                throw new IllegalStateException(
                        "Prompt not found: " + agent.getSystemPromptName());
            }

            PromptContext context = PromptContext.builder()
                    .promptTemplate(promptTemplate)
                    .userMessage(request.getUserMessage())
                    .promptVariables(
                            request.getPromptContext() == null
                                    ? null : request.getPromptContext().getPromptVariables())
                    .build();
            String systemContent = promptRenderer.render(context);
            String answer = chatClient
                    .prompt()
                    .system(systemContent)
                    .user(request.getUserMessage())
                    .tools(toolRegistry.getAllTools())
                    .call()
                    .content();
            return AgentResponse.builder()
                    .answer(answer)
                    .model(request.getModel() != null ? request.getModel() : agent.getModel())
                    .success(true)
                    .build();
        } catch (Exception e) {
            return AgentResponse.builder()
                    .success(false)
                    .errorMessage(e.getMessage())
                    .model(request.getModel() != null ? request.getModel() : agent.getModel())
                    .build();
        }
    }
}
