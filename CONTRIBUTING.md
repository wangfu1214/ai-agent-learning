# Contributing

Thank you for your interest in contributing to AgentFlow!

We welcome contributions of all kinds, including bug fixes, new features, documentation improvements, and design discussions.

---

## Development Workflow

The recommended development workflow is:

1. Fork the repository
2. Create a feature branch
3. Implement your changes
4. Write or update documentation
5. Submit a Pull Request

---

## Branch Naming

Please use the following naming conventions:

```text
feature/model-router
feature/memory-spi
feature/rag
feature/mcp
bugfix/chat-executor
docs/readme
```

---

## Commit Convention

This project follows the Conventional Commits specification.

Examples:

```text
feat: add model router
fix: fix prompt loading issue
refactor: simplify tool registry
docs: update roadmap
test: add chat executor tests
chore: upgrade spring boot version
```

---

## Coding Guidelines

Please follow these principles when contributing:

- Prefer constructor injection.
- Keep controllers lightweight.
- Separate AI infrastructure from business modules.
- Keep business logic inside services.
- Keep tools focused on AI interaction only.
- Follow SOLID principles.
- Write readable and maintainable code.

---

## Pull Request Checklist

Before submitting a Pull Request, please ensure:

- Code compiles successfully.
- All tests pass.
- Documentation has been updated if necessary.
- Changelog has been updated for user-visible changes.
- Code follows project conventions.

---

## Code Review

Every Pull Request should be reviewed before merging.

Review focuses on:

- Architecture
- Readability
- Extensibility
- Maintainability
- Documentation