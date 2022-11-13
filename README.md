
# **mt-taf**

Test Automation Framework for backend systems

**Introduction:**

The goal of this automation framework is to create scalable test cases, easy to use and enhance the framework based on need.

**Framework Design:**

The Framework design was consider in account with microservice architecture in mind.

Some benefits stated below:

1. DTO resembles the api contract. It contains the request and response class. Any change in the api contract. This will be single place to change.
2. Test implementation provide functionality to implement the test strategy based on feature/service.
3. Each implementation represents a service. Hence, the code patterns are not tightly coupled.

**Architecture in High Level:**

Architecture diagram represent the internal implementation of automation framework. 

![Architecture](/asset/Architecture.png)

**Execution:**

The execution diagram explain about how this automation framework can be scalable.

![Execution](/asset/Execution.png)

**Improvements:**
* Data provider for test from a different source (json,csv, dynamically generated data)
* Concurrency test pattern implementation
* Integration with test management tools
* Secret management
* Retry analyzer with specific exception format validation