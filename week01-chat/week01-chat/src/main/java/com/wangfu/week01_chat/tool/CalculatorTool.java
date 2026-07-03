package com.wangfu.week01_chat.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTool {

    @Tool(description = "获取两个数的相加结果,当用户需要做加法计算时调用")
    public int add(int a, int b){
        return a + b;
    }
}
