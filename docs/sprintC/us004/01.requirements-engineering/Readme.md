# US04 - As an HRM, I want to assign one or more skills to a collaborator.




## 1. Requirements Engineering


### 1.1. User Story Description

_As an HRM, I want to assign one or more skills to a collaborator._

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

_The skills must be clearly defined and described._

_When assigning competence/s to a worker._

_It must be possible assigning one or more skills to a collaborator each time._



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

_AC1 - The system allows HRM to assign one or more skills to a collaborator._

_AC2 - Must be a collaborator of the company._

_AC3 - It must be impossible to assign skills to collaborator who are not in the company's database._ 

### 1.4. Found out Dependencies

_US04 depends the US01._

### 1.5 Input and Output Data

_Input: 

Typed data: Collaborator's name; 

Selected data: Worker's role; 

Selected: skills to be assigned._ 

_Output - Updated record of collaborator skills._

### 1.6. System Sequence Diagram (SSD)


![US004-SSD](svg/us004-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks

_Give clear feedback on the outcome of the skills assignment.
 Deal with pre-existing employee skills during assignment._

