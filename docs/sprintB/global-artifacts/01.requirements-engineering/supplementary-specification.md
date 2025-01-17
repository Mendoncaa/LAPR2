# Project Supplementary Specification (FURPS+)

This document outlines the supplementary specification based on the FURPS+ model for our project, covering functionality, usability, reliability, performance, and supportability, along with design, implementation, interface, and physical constraints.

## Functionality

The system is designed to support the management of various parks owned by the organization. Key functionalities include:

- **Admin Management**: Admins manage the organization, assign jobs, and approve teams generated by the system for tasks.
- **Employee Management**: Employees have jobs, various skills, and are eventually assigned to teams to perform tasks.
- **Team Utilization**: Teams use vehicles, tools, and machines to perform tasks.
- **Task Scheduling**: Tasks are scheduled on an agenda and are performed in the parks.
- **Audit, Reporting, and Security**: Essential functions not directly related to user stories but integral to system integrity and operations.

## Usability

The system emphasizes a user-friendly interface with a focus on:

- **Error Prevention**: Validation of user credentials to prevent unauthorized access.
- **Interface Aesthetics and Design**: Two main options for login and signup, with tailored sub-menus for admin and non-admin users based on their roles and responsibilities.
- **Color blindness**: This application is not adapted for people with color blindness.

## Reliability

Given the project's scope, we currently do not predict significant failures, aiming for:

- Integrity, compliance, and interoperability of the software without specifying the frequency and severity of failures or recovery mechanisms.

## Performance

Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability.

The system should load pages and perform actions quickly. The system should be able to handle concurrent user requests without slowdowns. The system should have reasonable response times for data queries and updates.

## Supportability
_ The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility, configurability, installability, scalability and more.
_ This application is supported by the following Operating Systems: Windows and MacOS.
- ### Testability
    - The development team must implement unit tests for all methods The unit tests should be implemented using the JUnit 5 framework. 
- ### Adaptability
    - 
- ### Maintainability
    - The system should have documentation and support resources available to all actors.
- ### Compatibility
    - The system must be compatible with different devices.
- ### Configurability
    - ""
- ### Installability
    - The system should be easy to install and maintain.
- ### Scalability
    - The system should be modular and allow for easy upgrades and additions.


## Design Constraints

Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc.
  

- #### Mandatory standards/patterns: 
  - GRASP
  - SOLID
  - Modularity
  - Tell, Don't Ask (Principle)
  - Test-Driven Design (RDD)
  - OO software analysis and design practices
- #### Development tools: 
  - PlantUML 
  - Markdown
  - IntelliJ IDE or Visual Studio Code
  - JUnit Framework
  - Bitbucket 

## Implementation Constraints

- #### Mandatory standards/patterns:
    - JavaDoc
- #### Implementation languages:
  - Java
- #### Java Plugins:
  - JUnit Framework


## Interface Constraints

Specifies or constraints the features inherent to the interaction of the system being developed with other external systems

## Physical Constraints

[To be specified]

Please note that sections marked [To be specified] should be updated as the project progresses and more information becomes available.
