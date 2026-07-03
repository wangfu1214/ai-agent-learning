package com.wangfu.week01_chat.service;

import com.wangfu.week01_chat.response.ChatResponse;

public interface ChatService {

    /**
     *
     *
     * @param message 入口参数
     * @return
     */
    ChatResponse chat(String message);
}
