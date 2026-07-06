package com.wangfu.agentflow.ai.agent.factory;

import com.wangfu.agentflow.ai.agent.Agent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class AgentFactory {

    public Agent create(com.wangfu.agentflow.ai.agent.annotation.Agent agent) {
        return Agent.builder()
                .model(agent.model())
                .name(agent.name())
                .description(agent.description())
                .systemPromptName(agent.systemPrompt())
                .toolNames(List.of(agent.tools()))
                .enabled(agent.enabled())
                .build();
    }
}
