# US026 - As a GSM, I want to assign one or more vehicles to an entry in the Agenda.




## 1. Requirements Engineering



### 1.1. User Story Description

As Green Spaces Manager in the organization, I want to assign one or more vehicle to an entry task in the Agenda.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

Agenda is a state of a tasks that has a scheduled date and time of execution and can be assigned with available vehicles and team.

**From client meeting:**

Client clarification, vehicle must be available in that task period to be assigned.


### 1.3. Acceptance Criteria

**AC1** - Vehicles selected must be available in the date and time of execution scheduled.

**AC2** - Only GSM responsible for the Green Space in that entry can assign vehicles.

### 1.4. Found out Dependencies

This user story requires tasks in the To-Do list to be scheduled first (US22 - "As a GSM, I want to add a new entry in the Agenda").

### 1.5 Input and Output Data

**Input Data:** 
* Selected data: 
  * Task
  * Vehicles

**Output Data:**

* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)


![US026-SSD](svg/us026-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks

After the first vehicle is assigned, it should be possible to add more vehicles.


  



