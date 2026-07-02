package com.wangfu.week01_chat.controller;

import com.wangfu.week01_chat.record.WeatherRecord;
import com.wangfu.week01_chat.tool.CalculatorTool;
import com.wangfu.week01_chat.tool.TimeTool;
import com.wangfu.week01_chat.tool.WeatherTool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToolController {

    private final TimeTool timeTool;

    private final CalculatorTool calculatorTool;

    private final WeatherTool weatherTool;

    public ToolController(TimeTool timeTool, CalculatorTool calculatorTool, WeatherTool weatherTool) {
        this.timeTool = timeTool;
        this.calculatorTool = calculatorTool;
        this.weatherTool = weatherTool;
    }

    @GetMapping("/time")
    public String time() {
        return timeTool.currentTime();
    }

    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b){
        return calculatorTool.add(a, b);
    }

    @GetMapping("/weather")
    public WeatherRecord weather (@RequestParam String city) {
        return weatherTool.weather(city);
    }
}
