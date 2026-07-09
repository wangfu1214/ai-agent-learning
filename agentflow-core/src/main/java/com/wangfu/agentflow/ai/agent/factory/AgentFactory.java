package com.wangfu.agentflow.ai.agent.factory;

import com.wangfu.agentflow.ai.agent.Agent;
import com.wangfu.agentflow.ai.model.ModelOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class AgentFactory {

    public Agent create(com.wangfu.agentflow.ai.agent.annotation.Agent agent) {
        return Agent.builder()
                .modelOptions(ModelOptions.builder()
                        .provider(agent.provider())
                        .model(agent.model())
                        .build())
                .name(agent.name())
                .description(agent.description())
                .systemPromptName(agent.systemPrompt())
                .toolNames(List.of(agent.tools()))
                .enabled(agent.enabled())
                .build();
    }
}
