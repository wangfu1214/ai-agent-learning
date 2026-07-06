package com.wangfu.agentflow.ai.model;

import com.wangfu.agentflow.ai.agent.Agent;
import com.wangfu.agentflow.ai.agent.AgentRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelResolverTest {

    private final ModelResolver modelResolver = new ModelResolver();

    @Test
    void shouldUseRequestModelFirst() {
        Agent agent = Agent.builder()
                .modelOptions(ModelOptions.builder()
                        .model("agent-model")
                        .build())
                .build();

        AgentRequest request = AgentRequest.builder()
                .model("request-model")
                .build();

        String model = modelResolver.resolveModel(agent, request);

        assertEquals("request-model", model);
    }

    @Test
    void shouldFallbackToAgentModel() {
        Agent agent = Agent.builder()
                .modelOptions(ModelOptions.builder()
                        .model("agent-model")
                        .build())
                .build();

        AgentRequest request = AgentRequest.builder().build();

        String model = modelResolver.resolveModel(agent, request);

        assertEquals("agent-model", model);
    }

    @Test
    void shouldReturnNullWhenNoModelConfigured() {
        Agent agent = Agent.builder().build();
        AgentRequest request = AgentRequest.builder().build();

        String model = modelResolver.resolveModel(agent, request);

        assertNull(model);
    }
}