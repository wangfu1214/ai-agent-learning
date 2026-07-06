package com.wangfu.agentflow.ai.agent.factory;

import com.wangfu.agentflow.ai.agent.annotation.Agent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgentFactoryTest {

    private final AgentFactory agentFactory = new AgentFactory();

    @Agent(
            name = "order-agent",
            description = "订单助手",
            systemPrompt = "default-system",
            tools = {"order", "time"},
            model = "deepseek-chat"
    )
    static class OrderAgentDeclaration {
    }

    @Test
    void shouldCreateAgentFromAnnotation() {
        Agent annotation = OrderAgentDeclaration.class.getAnnotation(Agent.class);

        com.wangfu.agentflow.ai.agent.Agent agent =
                agentFactory.create(annotation);

        assertEquals("order-agent", agent.getName());
        assertEquals("订单助手", agent.getDescription());
        assertEquals("default-system", agent.getSystemPromptName());
        assertEquals(2, agent.getToolNames().size());
        assertTrue(agent.getToolNames().contains("order"));
        assertTrue(agent.getToolNames().contains("time"));
        assertEquals("deepseek-chat", agent.getModelOptions().getModel());
        assertTrue(agent.isEnabled());
    }
}