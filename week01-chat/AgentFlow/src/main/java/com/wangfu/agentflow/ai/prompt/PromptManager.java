package com.wangfu.agentflow.ai.prompt;

import org.springframework.stereotype.Component;

@Component
public class PromptManager {

    public String systemPrompt(){
        return PromptTemplate.DEFAULT_SYSTEM;
    }
}
