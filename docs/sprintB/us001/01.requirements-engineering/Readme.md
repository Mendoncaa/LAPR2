# US001 - Register skills that may be appointed to a collaborator




## 1. Requirements Engineering


### 1.1. User Story Description

_As a HRM, I want to register skills that may be appointed to a collaborator._

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

_The skills must be clearly defined and described._

_Options of add, edit and delete skills must be defined._

_It must be easy visualize the skills of each collaborator._

_Skills must be linked to the individual profile of each employee._

**From the client clarifications:**

> **Question:** "What should the system do when a skill that already exists is created?"
>
> **Answer:** "By definition, it's not possible to have duplicate values in a set. Checking for duplicates is not a business rule; it's a technical-level requirement."

> **Question:** "Which are the skills accepted? Or should we enable the HRM to introduce anything as a skill?"
>
> **Answer:** "All, it's up to HRM to decide. (special characters or algarisms should not be allowed in the skill name)"


### 1.3. Acceptance Criteria

_AC1 - Skills can be registered and appointed to collaborator by the HRM._

_AC2 - Every skills must be registered._

_AC3 - Identify skills names._

### 1.4. Found out Dependencies

_"US04 - As an HRM, I want to assign one or more skills to a collaborator." depends on this US01, because it is on this one that skills are registered._

### 1.5 Input and Output Data

Input - Skill.

Output - List of collaborator's skills.

### 1.6. System Sequence Diagram (SSD)

![US001-SSD](svg/us001-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks

_Maintain skills up to date to ensure accuracy of workers' skills.
 The system must handle the introduction of input errors, and process as invalid data.
 Users must be given an adequate explanation of how the program works._


## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 

![US001-DM](svg/us001-domain-model.svg)

### 2.2. Other Remarks

__ 


## 3. Design - User Story Realization 

### 3.1. Rationale

**The rationale grounds on the SSD interactions and the identified input/output data.**

| Interaction ID | Question: Which class is responsible for... | Answer  | Justification (with patterns)  |
|:-------------  |:--------------------- |:------------|:---------------------------- |
| Step 1  		 |							 |             |                              |
| Step 2  		 |							 |             |                              |
| Step 3  		 |							 |             |                              |
| Step 4  		 |							 |             |                              |
| Step 5  		 |							 |             |                              |
| Step 6  		 |							 |             |                              |              
| Step 7  		 |							 |             |                              |
| Step 8  		 |							 |             |                              |
| Step 9  		 |							 |             |                              |
| Step 10  		 |							 |             |                              |  

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are:

* Class1
* Class2
* Class3

Other software classes (i.e. Pure Fabrication) identified:

* xxxxUI  
* xxxxController

## 3.2. Sequence Diagram (SD)

_In this section, it is suggested to present an UML dynamic view representing the sequence of interactions between software objects that allows to fulfill the requirements._

![USXXX-SD](svg/usXXX-sequence-diagram.svg)

## 3.3. Class Diagram (CD)

_In this section, it is suggested to present an UML static view representing the main related software classes that are involved in fulfilling the requirements as well as their relations, attributes and methods._

![USXXX-CD](svg/usXXX-class-diagram.svg)


# 4. Tests 
_In this section, it is suggested to systematize how the tests were designed to allow a correct measurement of requirements fulfilling._ 

**_DO NOT COPY ALL DEVELOPED TESTS HERE_**

**Test 1:** Check that it is not possible to create an instance of the Example class with null values. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Exemplo instance = new Exemplo(null, null);
	}

_It is also recommended to organize this content by subsections._


# 5. Construction (Implementation)

_In this section, it is suggested to provide, if necessary, some evidence that the construction/implementation is in accordance with the previously carried out design. Furthermore, it is recommeded to mention/describe the existence of other relevant (e.g. configuration) files and highlight relevant commits._

_It is also recommended to organize this content by subsections._ 


# 6. Integration and Demo 

_In this section, it is suggested to describe the efforts made to integrate this functionality with the other features of the system._


# 7. Observations

_In this section, it is suggested to present a critical perspective on the developed work, pointing, for example, to other alternatives and or future related work._