package com.wangfu.week01_chat.controller;

import com.wangfu.week01_chat.tool.CalculatorTool;
import com.wangfu.week01_chat.tool.TimeTool;
import com.wangfu.week01_chat.tool.WeatherTool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToolController {

    @GetMapping("/time")
    public String time() {
        TimeTool timeTool = new TimeTool();
        return timeTool.currentTime();
    }

    @GetMapping("/add")
    public Integer add(@RequestParam int a, @RequestParam int b){
        CalculatorTool calculatorTool = new CalculatorTool();
        return calculatorTool.add(a, b);
    }

    @GetMapping("/weather")
    public String weather (@RequestParam String city) {
        WeatherTool weatherTool = new WeatherTool();
        return weatherTool.weather(city);
    }
}
