package com.wangfu.week01_chat.response;

public record ChatResponse(

        String answer,

        String model,

        Long elapsed,

        Integer promptTokens,

        Integer completionTokens

){}
