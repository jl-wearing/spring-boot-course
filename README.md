# Spring Start Here: Journey Through Spring Boot

A comprehensive, chapter-by-chapter implementation of Spring Framework fundamentals based on *Spring Start Here* by Laurențiu Spilcă. Covers IoC, DI, AOP, and Spring Data.

<img width="882" height="736" alt="image" src="https://github.com/user-attachments/assets/a8ff7617-15e6-4f49-95bc-98bff8158b47" />


---

## Chapters Covered

**Part 1 — Fundamentals**
- ✅ Spring in the Real World
- ✅ The Spring Context: Defining Beans
- ✅ The Spring Context: Wiring Beans
- ✅ The Spring Context: Using Abstractions
- ✅ The Spring Context: Bean Scopes and Life Cycle
- ✅ Using Aspects with Spring AOP

**Part 2 — Implementation**
- ✅ Understanding Spring Boot and Spring MVC
- ✅ Implementing Web Apps with Spring Boot and Spring MVC
- ✅ Using the Spring Web Scopes
- ✅ Implementing REST Services
- ✅ Consuming REST Endpoints
- ✅ Using Data Sources in Spring Apps
- ✅ Using Transactions in Spring Apps
- ✅ Implementing Data Persistence with Spring Data
- 🟠 Testing your Spring App

---

##  Project Overview

The goal of this project was to master the core "magic" behind the Spring Framework. By moving chapter by chapter, I built a solid foundation in how Spring manages objects, handles cross-cutting concerns, and connects to the web and databases.

### Part 1: The Core (The "How it Works")
- **The Spring Context:** Managing beans using `@Configuration`, `@Bean`, and stereotype annotations (`@Component`, `@Service`, `@Repository`).
- **Dependency Injection (DI):** Mastering wiring techniques — using `@Autowired`, constructor injection, and handling multiple beans of the same type.
- **Aspect-Oriented Programming (AOP):** Implementing Aspects to decouple "plumbing" code (like logging or security) from business logic.

### Part 2: Spring Web & Data
- **Spring MVC:** Building REST endpoints and web apps using `@Controller` and `@RestController`.
- **Bean Scopes:** Understanding the lifecycle of Singleton, Prototype, Request, and Session scoped beans.
- **Persistence:** Connecting to relational databases using `JdbcTemplate` and Spring Data.
- **Consuming Endpoints:** Using `RestTemplate`, `WebClient`, and OpenFeign to communicate between services.

---

## Personal Takeaways

Before this book, I was fairly confident in Java; I understood the language, could build things with it, and felt comfortable with its fundamentals. I had no experience whatsoever with Spring, but I had seen code from videos I initially attempted to learn from online. For example, annotations would appear, objects would get created, dependencies would wire themselves together, and somehow it all just worked. I wanted to understand *why*.

*Spring Start Here* gave me that understanding. Starting with the Spring Context, I learned that all that "magic" has a name called Inversion of Control and that Spring is simply a very well-designed framework for managing your objects and their relationships.

The concepts that stuck with me most were the different ways to define and wire beans, how Dependency Injection removes the need to manually connect objects together, and how Aspect-Oriented Programming lets you pull cross-cutting concerns like logging and security completely out of your business logic.

By the end, I had gone from someone who knew nothing about Spring, to someone who could reason about what was happening under the hood; From how beans are scoped and managed through their lifecycle, to building REST services, connecting to databases, and writing tests.

The commits in this repository reflect that journey, chapter by chapter.
