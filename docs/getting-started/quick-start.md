# AgentFlow Quick Start

## 1. Add Dependency

```xml
<dependency>
    <groupId>com.wangfu</groupId>
    <artifactId>agentflow-spring-boot-starter</artifactId>
</dependency>
```

## 2. Configure Model

application.yml:

```yaml
spring:
  ai:
    openai:
      base-url: https://api.deepseek.com
      api-key: ${DEEPSEEK_API_KEY}

agentflow:
  enabled: true
```

## 3. Create Agent

```java
@Agent(
        name = "order-agent",
        description = "订单助手",
        systemPrompt = "default-system",
        tools = {"order"}
)
public class OrderAgent {
}
```

## 4. Execute Agent

```java
AgentRequest request =
        AgentRequest.builder()
                .userMessage("查询订单")
                .build();

AgentResponse response =
        agentExecutor.execute(
                "order-agent",
                request
        );
```

## Architecture

```text
Application

↓

AgentFlow Starter

↓

AgentFlow Core

↓

Spring AI

↓

LLM
```