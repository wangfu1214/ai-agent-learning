graph TD

A[ChatController]
B[ChatService]
C[ChatExecutor]

D[PromptManager]
E[ToolRegistry]
F[ChatClient]

G[TimeTool]
H[WeatherTool]
I[CalculatorTool]
J[OrderTool]

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

J --> K
K --> L