package com.wangfu.agentflow.order.tool;

import com.wangfu.agentflow.ai.tool.annotation.AgentTool;
import com.wangfu.agentflow.order.model.OrderInfo;
import com.wangfu.agentflow.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@AgentTool(name = "order", description = "订单查询工具", category = "business")
public class OrderTool {

    private final OrderService orderService;

    @Tool(description = """
            查询订单信息。
            
            适用场景：
            - 查询订单详情
            - 查询订单状态
            - 查询物流状态
            - 查询订单金额
            
            参数：
            - orderId：订单编号
            """)
    public OrderInfo getOrderInfo(String orderId) {
        return orderService.findById(orderId);
    }
}
