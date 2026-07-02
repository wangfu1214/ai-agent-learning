package com.wangfu.week01_chat.tool;

import java.time.LocalDateTime;

public class TimeTool {

    public String currentTime(){
        return LocalDateTime.now().toString();
    }
}
