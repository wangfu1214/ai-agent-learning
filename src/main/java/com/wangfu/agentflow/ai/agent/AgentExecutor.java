package com.wangfu.agentflow.ai.agent;

import com.wangfu.agentflow.ai.agent.resolver.AgentResolver;
import com.wangfu.agentflow.ai.agent.runtime.AgentRuntime;
import com.wangfu.agentflow.ai.model.ModelResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgentExecutor {

    private final AgentRuntime agentRuntime;

    private final AgentResolver agentResolver;

    private final ModelResolver modelResolver;

    public AgentResponse execute(Agent agent, AgentRequest request) {
        try {
            return agentRuntime.run(agent, request);
        } catch (Exception e) {
            return AgentResponse.builder()
                    .success(false)
                    .errorMessage(e.getMessage())
                    .model(modelResolver.resolveModel(agent, request))
                    .build();
        }
    }

    public AgentResponse execute(String agentName, AgentRequest request) {
        Agent agent = agentResolver.resolve(agentName);
        return execute(agent, request);
    }
}
