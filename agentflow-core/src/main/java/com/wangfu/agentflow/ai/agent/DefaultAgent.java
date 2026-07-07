package com.wangfu.agentflow.ai.agent;

import com.wangfu.agentflow.ai.agent.annotation.Agent;

@Agent(
        name = "default-agent",
        description = "默认助手",
        systemPrompt = "default-system",
        tools = {"time", "weather", "calculator", "order"},
        model = "deepseek-chat"
)
public class DefaultAgent {

}