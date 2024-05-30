# US021 - Add a New Entry to the To-Do List

## 1. Requirements Engineering

### 1.1. User Story Description

As a Green Space Manager (GSM), I want to add a new entry to the To-Do List.

### 1.2. Customer Specifications and Clarifications 

**From the client clarifications:**

> **Question:** Hi client, when a To-Do List entry is planned and moves to the Agenda, the status change from "Pending" to "Planned". Should this entry be removed from the To-Do List or just change status to "Planned" as it is on the Agenda?
>
> **Answer:** Changing the status in the To-Do list to Planned seems to be a good approach.

> **Question:** Boa tarde, se existem vários GSM quando um GSM cria um green space esse green space fica automaticamente associado a ele ou deve existir um menu em que um "administrador" geral da empresa escolhe a que cada green space cada GSM deve mandar?
>
> **Answer:** Não existem USs previstas para essa gestão. Por uma questão de simplicidade podem assumir que o GSM que cria o GS fica como gestor desse mesmo GS.

> **Question:** Is it mandatory for the program to have multiple GSM? If so, should each green space be associated with a responsible GSM? In other words, can only the GSM assigned to a specific green space register a new entry for the to-do list?
>
> **Answer:** The program can have multiple GSM. Yes. Yes.

> **Question:** When a to-do list entry is added to the agenda, what should its state be?
>
> **Answer:** Maybe "planned".

> **Question:** What time unit should be used for the duration of the task?
>
> **Answer:** Hour and/or days.

> **Question:** When a new entry is added to the To-Do list, the default status of that task will be "pending" or no status at all is considered on To-Do list? Similarly, when a new entry is added to the Agenda, the status of that task will be, by default, set to "planned", right?
>
> **Answer:** "Pending" as default for to-do list entries and "Planned" as default for Agenda entries, sounds good.

> **Question:** Our team is unsure about what the exact inputs for the Green Space, To-Do List Entry, and Agenda entry exactly are. We understand that type (garden, medium-size, large-size), area, name, and address are required inputs for a Green Space (and if we are wrong in this, please correct us), but are there any other inputs that we are unaware of?
>
> **Answer:** Seems enough. 

> **Question:** And when it comes to To-Do List entries, we identified a state (planned, postponed, completed, canceled), a green space, a title, and a description as inputs for a To-Do List entry. But are there any more?
>
> **Answer:** In the text you can find: the degree of urgency (High, Medium, and Low), and the approximate expected duration.

> **Question:** We also know that an Agenda entry has a target date, but is this target date supposed to be inputted upon transferring a task from the to-do list to the agenda, or is it supposed to be inputted upon creating the task in the to-do list?
>
> **Answer:** To-do list entries doesn't have dates!

> **Question:** Finally, during the last client meeting, we became aware that some tasks are meant to be reoccurring rather than occasional. Is this something that should be asked on creating the task in the to-do list? If so, what inputs should we expect from the user? The task's frequency in days?
>
> **Answer:** For the current proof-of-concept there is no need to distinguish between recurring and occasional tasks.

> **Question:** Are the new entries on the list divided in categories? For example, the statement talks about regular and occasional tasks, should the distinction be made for the user?
>
> **Answer:** In the scope of the current proof-of-concept, there are no user stories using those categories.

### 1.3. Acceptance Criteria

* **AC1** The new entry must be associated with a green space managed by the GSM.
* **AC2** The green space for the new entry should be chosen from a list presented to the GSM.

### 1.4. Found out Dependencies

There is a dependency on:

* US20 - Register a Green Space, as each To-Do List entry must be associated with an existing green space.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
  - Title of the task
  - Description of the task
  - Approximate expected duration (in hours or days)

* Selected data:
  - Green space
  - Degree of urgency (High, Medium, Low)

**Output Data:**

* Confirmation message indicating successful addition of the task to the To-Do List
* Error message if required fields are missing or invalid

### 1.6. System Sequence Diagram (SSD)

