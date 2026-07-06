# Changelog

All notable changes to this project will be documented in this file.

The format is inspired by Keep a Changelog and follows Semantic Versioning.

## [0.3.0] - 2026-07

### Added

- Introduced annotation-driven Tool Framework.
- Added ToolMetadata and ToolDefinition.
- Added ToolScanner for automatic tool discovery.
- Added ToolRegistry for centralized tool management.
- Introduced @AgentTool annotation.

## [0.2.0] - 2026-07

### Added

- Introduced AIContext for unified AI execution context.
- Added PromptManager for centralized prompt management.
- Added ToolRegistry for tool registration.
- Added ChatExecutor to separate AI execution from business services.
- Added Order domain (OrderInfo, OrderService, OrderRepository, OrderTool).

### Changed

- Refactored ChatService to delegate AI requests to ChatExecutor.
- Improved project architecture by separating AI infrastructure from business modules.

## [0.1.0] - 2026-06

### Added

- Initial Spring Boot project.
- Integrated Spring AI.
- Implemented ChatClient.
- Added ChatController and ChatService.
- Added TimeTool, WeatherTool and CalculatorTool.