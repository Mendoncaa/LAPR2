# Object-Oriented Analysis for Green Spaces Management System

## Introduction

This document outlines the object-oriented analysis conducted for the development of an Minimal Viable Product (PVM) aimed at supporting the management and maintenance of green spaces. 

## Rationale for Identifying Conceptual Classes

Conceptual classes were identified by analyzing the client specifications, focusing on nouns (for concepts) and verbs (for relations) used in the description. The list of candidate conceptual classes was inspired by the categories suggested in "Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development".

### Conceptual Class Categories

#### Business Transactions


- **Tasks**: Categories of work assigned to Teams and related to GreenSpaces, organized by an Agenda.

#### Transaction Line Items

- **Skills**: Abilities that a TeamMember can possess, created and assigned by HRM.

#### Product/Service Related

- **GreenSpaces**: Types of spaces Tasks are related to, used by GSU.

#### Transaction Records

- **Malfunctions, Faults, Comments**: Records related to the operational status of green spaces, managed and reported through the Portal by GSU.

#### Roles of People or Organizations

- **Employee** : Various types of roles (in case of the TeamMember, a Job) within the organization, each with distinct responsibilities and interactions within the system. Can be a: TeamMember, HRM, GSM, VFM.


- **Teams**: Groups of TeamMembers managed by an Employee, characterized by their number of elements and required skills.

-**GSU**: User of a green space that reports malfunctions, faults and makes comments about the green space on the portal.


#### Noteworthy Events

- **Agenda**: A schedule organizing Tasks, managed by GSM.

#### Physical Objects

- **Vehicles, Machines, Equipment**: Objects required for the maintenance and management of GreenSpaces, managed by VFM.

#### Catalogs

- **Portal**: A platform aggregating reports and feedback on green spaces, managed by GSM.

#### Organizations

- **Organization**: The entity employing all Employees and overseeing the system's operations.

## Rationale for Identifying Associations

Associations were identified based on the relevance of connections between object instances, derived from common association patterns such as part-whole relationships, containment, description, and management or ownership links.

### Key Associations

* **_Organization_** employs **_Employee_**
* **_Employee_** manages **_Teams_** and can be a **_TeamMember_**, **_HRM_**, **_GSM_**, or **_VFM_**
* **_TeamMember_** is managed by **_HRM_** and can be assigned **_Skills_**
* **_Jobs_** and **_Skills_** are created and assigned by **_HRM_**
* **_Teams_** are assigned to **_Tasks_**, which relate to **_GreenSpaces_**
* **_GSM_** manages the **_Portal_** and **_Agenda_**
* **_VFM_** manages **_Vehicles_**, **_Machines_**, and **_Equipment_**
* **_Portal_** aggregates **_Malfunctions_**, **_Faults_**, and receives **_Comments_**
* **_GSU_** uses **_GreenSpaces_** and reports issues through the **_Portal_**


| Concept (A) 		  | Association   	 |  Concept (B) |
|-----------------|:---------------:|-------------:|
| Organization  	 | employs    		 	 |     Employee |
| Employee        |     manages     |        Teams |
| Employee        |   agreggates    |  TeamMembers |
| Employee        |   agreggates    |          HRM |
| Employee        |   agreggates    |          GSM |
| Employee        |   agreggates    |          VFM |
| HRM             |     manages     |   TeamMember |
| HRM             | creates/assigns |          Job |
| HRM             | creates/assigns |       Skills |
| TeamMembers     |      have       |          Job |
| TeamMembers     |    can have     |       Skills |
| Teams           | have |  TeamMembers |
| Teams           | are assigned to |        Tasks |
| GSM             | manages |       Agenda |
| GSM             | manages |        Tasks |
| VFM             | manages |     Vehicles |
| VFM             | manages |     Machines |
| VFM             | manages |    Equipment |
| Portal          | agreggates | Malfunctions |
| Portal          | agreggates |       Faults |
| Portal          | agreggates |     Comments |
| Gsu             | uses | GreenSpaces |
| Gsu             | reports | Portal |
| Tasks           | are done | GreenSpaces |
## Domain Model

The domain model diagram provides a visual representation of the identified conceptual classes and their associations. Attributes for each concept have been defined based on the specifications provided.

![Domain Model](svg/project-domain-model.svg)

*Please note: The domain model diagram is to be included as an SVG file in the project documentation.*

## Conclusion

This analysis lays the groundwork for the design and implementation phases of the green spaces management system. The identified conceptual classes and associations form a robust domain model that aligns with the client's requirements and objectives for the project.
