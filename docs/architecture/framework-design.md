# AgentFlow Framework Design

## Overview

AgentFlow is designed as a Java enterprise AI Agent framework.

The core idea is to build reusable AI infrastructure instead of hard-coded AI demos.

AgentFlow currently follows four major framework patterns:

- Resource Pattern
- Annotation Pattern
- Registry Pattern
- Execution Pattern

---

## Resource Pattern

Resource Pattern is used for framework resources such as prompts.

```text
Prompt File
    ↓
PromptLoader
    ↓
PromptManager
    ↓
PromptRenderer
```

### Responsibilities

| Component | Responsibility |
|---|---|
| PromptLoader | Load prompt files from resources |
| PromptManager | Register and manage prompt templates |
| PromptRenderer | Render prompt templates with variables |

---

## Annotation Pattern

Annotation Pattern is used for declarative framework components such as tools and agents.

```text
@AgentTool / @Agent
        ↓
Scanner
        ↓
Factory
        ↓
Registry
```

### Responsibilities

| Component | Responsibility |
|---|---|
| Annotation | Declare metadata |
| Scanner | Discover annotated Spring beans |
| Factory | Convert declaration into runtime object |
| Registry | Manage runtime objects |

---

## Registry Pattern

Registry is used to manage framework runtime objects.

All registries should provide a consistent API:

```java
register()
get()
getAll()
contains()
size()
```

### Examples

- ToolRegistry
- AgentRegistry
- PromptManager

---

## Execution Pattern

Execution Pattern is used for runtime execution.

```text
Request
    ↓
Executor
    ↓
Response
```

### Examples

```text
AgentRequest
    ↓
AgentExecutor
    ↓
AgentResponse
```

---

## Design Principles

AgentFlow follows these principles:

- Keep business logic separate from AI infrastructure.
- Prefer explicit framework models over raw Map or String.
- Use annotations to declare metadata.
- Use scanners for discovery.
- Use factories for object creation.
- Use registries for lifecycle management.
- Use executors for runtime execution.
- Keep each class focused on one responsibility.
- Fail fast when framework resources are missing.
- Avoid premature abstraction.

---

## Current Core Architecture

```mermaid
flowchart TD

A[@AgentTool] --> B[ToolScanner]
B --> C[ToolDefinition]
C --> D[ToolRegistry]

E[Prompt File] --> F[PromptLoader]
F --> G[PromptManager]
G --> H[PromptRenderer]

I[@Agent] --> J[AgentScanner]
J --> K[AgentFactory]
K --> L[AgentRegistry]

M[AgentRequest] --> N[AgentExecutor]
L --> N
D --> N
H --> N
N --> O[AgentResponse]
```

---

## Future Direction

The next phase of AgentFlow will focus on Spring Boot integration:

- AgentResolver
- Auto Configuration
- Spring Boot Starter
- EnableAgentFlow