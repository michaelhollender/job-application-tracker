# Spring Boot app (v1 focus)
What I Learned (Spring Boot & REST Design)
Controller Responsibilities & Dependency Injection

While implementing the ApplicationController, I initially mixed object creation logic and endpoint handling, which led to compilation and design issues. Refactoring this helped me better understand Spring’s separation of concerns.

Key takeaways:

REST controllers should remain thin and focus only on HTTP concerns (request mapping, request/response models).

Business logic and object creation belong in the service layer, not controllers.

Constructor-based dependency injection is preferred over field injection because it:

Makes dependencies explicit

Improves testability

Prevents partially initialized beans

Controller methods must return explicit response types (DTOs or ResponseEntity) to clearly define API contracts.

This refactor clarified my API design, reduced coupling, and aligned the application with Spring Boot best practices.