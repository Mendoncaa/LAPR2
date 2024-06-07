# US021 - Add a New Entry to the To-Do List

## 3. Design - User Story Realization 

### 3.1. Rationale

Claro, aqui está o rationale para a US22 com base no Sequence Diagram que desenvolvemos anteriormente:

### 3.1. Rationale

| Interaction ID                               | Question: Which class is responsible for...                   | Answer                   | Justification (with patterns)                                                                       |
|:---------------------------------------------|:--------------------------------------------------------------|:-------------------------|:----------------------------------------------------------------------------------------------------|
| Step 1 - requests to add a new Agenda entry  | ... interacting with the actor?                               | AgendaUI                 | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the DM. |
|                                              | ... coordinating the US?                                      | AgendaController         | Pure Fabrication (System Interaction Controller)                                                    |
|                                              | ... knowing the user using the system?                        | UserSession              | IE: see Auth component documentation.                                                               |
| Step 2 - getPendingTasks                     | ... fetching pending tasks from the repository?               | TaskRepository           | IE: knows all tasks.                                                                                |
| Step 3 - getAvailableGreenSpaces             | ... fetching available green spaces from the repository?      | GreenSpaceRepository     | IE: knows all green spaces.                                                                         |
| Step 4 - addNewAgendaEntry                   | ... instantiating the selected Task with startDate?           | Employee                 | Pure Fabrication (Delegation of responsibility to manage the task).                                 |
|                                              | ... validating all data (local validation, e.g., mandatory)?  | Task                     | IE: owns its data.                                                                                  |
|                                              | ... validating all data (global validation, e.g., duplicates)?| TaskRepository           | IE: knows all tasks.                                                                                |
|                                              | ... saving the Agenda entry?                                  | TaskRepository           | IE: owns all tasks.                                                                                 |
| Step 5 - display operation success           | ... informing operation success?                              | AgendaUI                 | Pure Fabrication (Interaction with Actor)                                                           |

### Systematization

According to the rationale taken, the conceptual classes promoted to software classes are:

* Task
* GreenSpace
* Employee

Other software classes (i.e., Pure Fabrication) identified:

* AgendaUI  
* AgendaController
* UserSession
* TaskRepository
* GreenSpaceRepository
* AuthenticationRepository
* EmployeeRepository
* OrganizationRepository

### Additional Remarks

* The `Employee` class is responsible for calling the `planTaskInAgenda` method on the `Task` instance.
* The `Task` class is responsible for managing its own data and state.
* The `AgendaController` class coordinates the user's interactions with the system to add a new entry to the Agenda.
* The repository classes (`TaskRepository`, `GreenSpaceRepository`, `AuthenticationRepository`, `EmployeeRepository`, `OrganizationRepository`) are responsible for managing the storage and retrieval of data.

This rationale provides a structured basis for understanding how responsibilities are distributed among the classes and supports the creation of the Sequence Diagram for US22.

## 3.2. Sequence Diagram (SD)
