package com.wangfu.week01_chat.tool;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimeTool {

    public String currentTime(){
        return LocalDateTime.now().toString();
    }
}
