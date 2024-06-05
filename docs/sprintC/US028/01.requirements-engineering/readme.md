# US028 - As a Collaborator, I wish to consult the tasks assigned to me between two dates

## 1. Requirements Engineering

### 1.1. User Story Description

As a Collaborator, I wish to consult the tasks assigned to me between two dates.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

This US was created to allow collaborators to easily consult the tasks assigned to them within a specific date range, ensuring ordering by date and the ability to filter by task status.  

**From the client clarifications:**

> **Question:** ""As a Collaborator, I wish to consult the tasks assigned to me". That means that the collaborator can have more than one task assigned to them. To ensure that, the same task should be availvable for more than one team, am I right? The reason for that question is so that if a task is strictly related to only one team, a collaborator will end up being in two teams simultaneously, which cannot happen."
>
> **Answer:** "A team can have multiple task assigned, hence, if a collaborator belongs to a team. Besides, a collaborator can move from a team to another, so during, for instance, a month period a collaborator can belong to multiples teams."

> **Question:** "Could a task belong to different teams and collaborators?"
>
> **Answer:** "No."

> **Question:** "In the US28, the tasks consulted will be the ones that were assigned to the team/teams that collaborator is in, right?"
>
> **Answer:** "Right"

> **Question:** "Why do we need to show a list of green spaces? Are we assuming that one collaborator could work in 2 different parks?"
>
> **Answer:** "Yes, a collaborator can work in multiples green spaces"

> **Question:** "Do collaborators log in with a password (created by the respective manager when creating the collaborator), or with other information like the BI number or the TaxPayer?"
>
> **Answer:** "One can use email or taxpayer number."

> **Question:** "
While consulting tasks, how specific should be data presented to collaborator? Should it be all entries from the agenda with collaborator's team assigned or generic tasks that these entries refer to? As there is agenda entry, to-do list entry and task."
>
> **Answer:** "A "generic task" is something like "task type" or "template task", for instance "Prunning Trees".
When a GSM decides to insert a entry in the To-Do list, he selects a generic task, selects a park, defines the expected duration and the urgency.
Later, that To-do List entry will originate an Entry in the Agenda with a starting date/time. That Entry can be managed due to actions/events that happens, hence the Entry can be Canceled, Postponed or Completed."


### 1.3. Acceptance Criteria

* **AC1** The list of tasks spaces must be sorted by date.

* **AC2** The Collaborator should be able to filter the results by the status of the task.

* **AC3** 

### 1.4. Found out Dependencies

* There is a dependency on:

US28 depends on the following user stories:

"US21 - As a GSM, I want to add a new entry to the To-Do List.";

"US22 - As a GSM, I want to add a new entry in the Agenda.";

"US24 - As a GSM, I want to Postpone an entry in the Agenda to a specific future date";

"US25 - As a GSM, I want to Cancel an entry in the Agenda.".

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
  * Start Date
  * End Date
  * Task Status
  * Email or taxpayer number

**Output Data:**

* Task List


### 1.6. System Sequence Diagram (SSD)

![US00-SSD](svg/us001-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks

* Ensure that only authorized employees have access to task information and that data is protected against unauthorized access.
* The system must efficiently handle task queries even when there is a large volume of data or a large number of users accessing it simultaneously.
