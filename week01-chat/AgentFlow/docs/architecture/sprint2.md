graph TD

A[ChatController]

B[ChatService]

C[ChatExecutor]

D[PromptManager]

E[ToolRegistry]

F[ChatClient]

G[OrderTool]

H[WeatherTool]

I[TimeTool]

J[CalculatorTool]

K[OrderService]

L[OrderRepository]

A --> B

B --> C

C --> D
C --> E
C --> F

E --> G
E --> H
E --> I
E --> J

G --> K

K --> L