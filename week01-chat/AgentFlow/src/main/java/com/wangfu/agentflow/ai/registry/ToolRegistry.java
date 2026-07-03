package com.wangfu.agentflow.ai.registry;

import com.wangfu.agentflow.order.model.OrderInfo;
import com.wangfu.agentflow.order.tool.OrderTool;
import com.wangfu.agentflow.tool.CalculatorTool;
import com.wangfu.agentflow.tool.TimeTool;
import com.wangfu.agentflow.tool.WeatherTool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class ToolRegistry {

    private final Collection<Object> tools;

    public Object[] getAllTools() {
        return tools.toArray();
    }
}
