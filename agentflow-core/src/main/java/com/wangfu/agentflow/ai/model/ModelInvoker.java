package com.wangfu.agentflow.ai.model;

import com.wangfu.agentflow.ai.agent.Agent;
import com.wangfu.agentflow.ai.agent.AgentRequest;
import com.wangfu.agentflow.ai.agent.AgentResponse;

/**
 * Model invocation abstraction.
 *
 * Different implementations may delegate to
 * Spring AI, OpenAI SDK, LangChain4j, etc.
 */
public interface ModelInvoker {

    AgentResponse invoke(
            Agent agent,
            AgentRequest request,
            String systemPrompt
    );
}
