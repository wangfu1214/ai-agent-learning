package com.wangfu.agentflow.ai.model.spring;

import com.wangfu.agentflow.ai.model.ModelInvoker;
import com.wangfu.agentflow.ai.model.ModelProvider;
import com.wangfu.agentflow.extension.AgentFlowExtension;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@AgentFlowExtension(
        name = "spring-ai",
        description = "Spring AI Model Provider"
)
public class SpringAIModelProvider implements ModelProvider  {

    private final SpringAIModelInvoker modelInvoker;

    @Override
    public String name() {
        return "spring-ai";
    }

    @Override
    public ModelInvoker createInvoker() {
        return modelInvoker;
    }
}
