package com.wangfu.agentflow.ai.prompt;

public final class PromptTemplate {

    private PromptTemplate (){

    }


    public static final String DEFAULT_SYSTEM = """
            你是一名企业 AI 助手。

            请使用中文回答。

            回答简洁。

            不知道请明确说明不知道。

            如果可以使用工具，请优先调用工具。

            """;
}
