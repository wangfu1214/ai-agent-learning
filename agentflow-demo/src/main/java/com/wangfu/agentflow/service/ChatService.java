package com.wangfu.agentflow.service;

import com.wangfu.agentflow.response.ChatResponse;

public interface ChatService {

    /**
     *
     *
     * @param message 入口参数
     * @return
     */
    ChatResponse chat(String message);
}
