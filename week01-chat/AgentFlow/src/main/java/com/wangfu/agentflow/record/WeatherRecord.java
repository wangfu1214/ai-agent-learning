package com.wangfu.agentflow.record;

public record WeatherRecord(
        String city,
        Integer temperature,
        String weather
) {
}
