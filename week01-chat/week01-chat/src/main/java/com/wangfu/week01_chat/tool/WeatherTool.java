package com.wangfu.week01_chat.tool;

import com.wangfu.week01_chat.record.WeatherRecord;
import org.springframework.stereotype.Component;

@Component
public class WeatherTool {
    public WeatherRecord weather(String city){

        return new WeatherRecord("shenzhen", 32, "晴");

    }
}
