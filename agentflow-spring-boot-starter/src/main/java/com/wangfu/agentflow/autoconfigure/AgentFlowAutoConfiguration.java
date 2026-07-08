package com.wangfu.agentflow.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(
        prefix = "agentflow",
        name = "enabled",
        havingValue = "true",
        matchIfMissing = true
)
@EnableConfigurationProperties(AgentFlowProperties.class)
@ComponentScan(basePackages = "com.wangfu.agentflow.ai")
public class AgentFlowAutoConfiguration {
}
