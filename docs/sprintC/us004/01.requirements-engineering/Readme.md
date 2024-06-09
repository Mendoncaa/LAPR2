# US04 - As an HRM, I want to assign one or more skills to a collaborator.




## 1. Requirements Engineering


### 1.1. User Story Description

As an HRM, I want to assign one or more skills to a collaborator.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

The skills must be clearly defined and described.

When assigning competence/s to a worker.

It must be possible assigning one or more skills to a collaborator each time.



**From the client clarifications:**

> **Question:** "Is there a minimum or maximum number of skills?"
>
> **Answer:** "No."

> **Question:** "Is there any certification/proof needed to register a skill to a colaborator?"
>
> **Answer:** "No."

> **Question:** "Can a collaborator have no skills assigned?"
>
> **Answer:** "Yes."

### 1.3. Acceptance Criteria

* **AC1** The system allows HRM to assign one or more skills to a collaborator.

* **AC2** Must be a collaborator of the company.

* **AC3** It must be impossible to assign skills to collaborator who are not in the company's database. 

### 1.4. Found out Dependencies

* US04 depends on "US01 - As a Human Resources Manager (HRM), I want to register skills that a collaborator may have."

### 1.5 Input and Output Data

**Input Data:**

* Typed data: 
  * Collaborator's name 

* Selected data: 
  * Worker's role 

* Selected data: 
  * Skills to be assigned

**Output Data:** 

* Updated record of collaborator skills

### 1.6. System Sequence Diagram (SSD)


![US004-SSD](svg/us004-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks

* Give clear feedback on the outcome of the skills assignment.
* Deal with pre-existing employee skills during assignment.

