# AgentFlow Spring Boot Starter

Spring Boot integration for AgentFlow.

## Usage

Add dependency:

```xml
<dependency>
    <groupId>com.wangfu</groupId>
    <artifactId>agentflow-spring-boot-starter</artifactId>
</dependency>
```

Configure:

```yaml
agentflow:
  enabled: true
```

The starter automatically provides:

- Agent Runtime
- Prompt Framework
- Tool Framework
- Model Integration
```