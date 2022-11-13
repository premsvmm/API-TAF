
# **mt-taf**

Test Automation Framework for backend systems

**Introduction:**

The goal of this automation framework is to create scalable test cases, easy to use and enhance the framework based on need.

**Framework Design:**

The Framework design was consider in account with microservice architecture in mind.

Some of the benefits stated below:

1. DTO resembles the api contract. It contains the request and response class. Any change in the api contract. This will be single place to change.
2. Test implementation provide functionality to implement the test strategy based on feature/service.
3. Each implementation represent a service. Hence the code patterns are not tightly coupled.

**Architecture in High Level:**

![Architecture](/assets/Backend_Automation_ Architecture.png)

**Execution:**

![Execution](/assets/Execution.png)

**Improvements:**
* Data provider for test from a different source (json,csv, dynamically generated data)
* Concurrency test pattern implementation
* Integration with test management tools
* Secret management
* Retry analyzer with specific exception format validation
