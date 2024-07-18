# Codechella

A simple application to demonstrate how to implement a Spring Boot application using the clean architecture concept.

## Packages

### 1. domain

This is the application domain. Where the business logic must be.

#### 1.1 entity

Entities represent the main object of the application domain.
They have an identification and they are mutable.

Object values (Address) represent important objects but they don't have an identification.

### 2. application

Contains the use cases and classes used by the domain to interact with the external world.

#### 2.1 gateway

Responsible classes to define the interfaces/contracts for external interactions.
The use cases will use this contracts to be executed.

#### 2.2 usecase

Responsible classes to define the use cases of the application.

### 3. infra

Contains the classes with the frameworks used by the application.

#### 3.1 gateway

Implementation classes for the *application.gateway* interfaces.
These classes are linked with the frameworks used in the current project.

#### 3.2 persistence

Responsible classes to persist data. 