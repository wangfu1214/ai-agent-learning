package com.wangfu.week01_chat.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimeTool {

    @Tool(description = "获取当前时间，当用户需要获取当天几点几分时调用")
    public String currentTime(){
        return LocalDateTime.now().toString();
    }
}
