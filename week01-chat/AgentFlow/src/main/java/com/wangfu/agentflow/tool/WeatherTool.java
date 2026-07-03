package com.wangfu.agentflow.tool;

import com.wangfu.agentflow.ai.tool.AgentTool;
import com.wangfu.agentflow.record.WeatherRecord;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class WeatherTool  implements AgentTool {

    @Tool(description = "获取指定城市的天气，当用户需要询问某个城市天气，气温，是否下雨时调用")
    public WeatherRecord weather(String city){

        return new WeatherRecord("shenzhen", 32, "晴");

    }
}
