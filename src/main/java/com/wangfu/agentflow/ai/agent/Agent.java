package com.wangfu.agentflow.ai.agent;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Agent {

    /**
     * Agent 唯一名称
     */
    private String name;

    /**
     * Agent 描述
     */
    private String description;

    /**
     * 使用的系统 Prompt 名称
     */
    private String systemPromptName;

    /**
     * 可用 Tool 名称列表
     */
    private List<String> toolNames;

    /**
     * 使用的模型名称
     */
    private String model;

    /**
     * 是否启用
     */
    @Builder.Default
    private boolean enabled = true;
}