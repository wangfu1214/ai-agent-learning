package com.wangfu.week01_chat.tool;

import com.wangfu.week01_chat.record.WeatherRecord;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class WeatherTool {

    @Tool(description = "获取指定城市的天气，当用户需要询问某个城市天气，气温，是否下雨时调用")
    public WeatherRecord weather(String city){

        return new WeatherRecord("shenzhen", 32, "晴");

    }
}
