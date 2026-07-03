package com.wangfu.agentflow.tool;

import com.wangfu.agentflow.ai.tool.AgentTool;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTool implements AgentTool {

    @Tool(description = "获取两个数的相加结果,当用户需要做加法计算时调用")
    public int add(int a, int b){
        return a + b;
    }
}
