package com.wangfu.week01_chat.service.impl;

import com.wangfu.week01_chat.response.ChatResponse;
import com.wangfu.week01_chat.service.ChatService;
import com.wangfu.week01_chat.tool.CalculatorTool;
import com.wangfu.week01_chat.tool.TimeTool;
import com.wangfu.week01_chat.tool.WeatherTool;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatClient chatClient;

    private final CalculatorTool calculatorTool;

    private final TimeTool timeTool;

    private final WeatherTool weatherTool;

    @Override
    public ChatResponse chat(String message) {
        String answer = chatClient
                .prompt()
                .system("""
                        你是一个企业 AI 助手。
                        你可以根据用户问题选择合适的工具。
                        如果用户询问时间，请使用时间工具。
                        如果用户询问天气，请使用天气工具。
                        如果用户要求加法计算，请使用计算器工具。
                        回答必须使用中文，简洁清楚。
                        """)
                .user(message)
                .tools(calculatorTool, timeTool, weatherTool)
                .call()
                .content();
        return new ChatResponse(answer, "", 0L, 0,0);
    }
}
