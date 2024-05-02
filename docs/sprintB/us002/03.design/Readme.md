# US002 - As an HRM, I want to register a job. 

## 3. Design - User Story Realization 

### 3.1. Rationale


| Interaction ID | Question: Which class is responsible for...   | Answer              | Justification (with patterns)                                                                                 |
|:---------------|:----------------------------------------------|:--------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		     | 	... interacting with the actor?              | CreateJobUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		        | 	... coordinating the US?                     | CreateJobController | Controller                                                                                                    |
| 			  		        | 	... instantiating a new Job?                 | Organization        | Creator (Rule 1): in the DM Organization owns Jobs list.                                                      |
| 			  		        | ... knowing the user using the system?        | UserSession         | IE: see Auth component documentation.                                                                         |
| 			  		        | 							                                       | Organization        | IE: has its own Employees                                                                                     |
| 			  		        | 							                                       | Employee            | IE: knows its own data                                                                                        |
| Step 2  		     | 							                                       |                     |                                                                                                               |
| Step 3  		     | 	...saving the inputted data?                 | Job                 | IE: object created in step 1 has its own data.                                                                |
| Step 4  		     | 							                                       |                     |                                                                                                               |              
| Step 5  		     | 	... validating all data (local validation)?  | Job                 | IE: owns its data.                                                                                            | 
| 			  		        | 	... validating all data (global validation)? | Organization        | IE: knows all its jobs.                                                                                       | 
| 			  		        | 	... saving the created job?                  | Organization        | IE: owns all its jobs.                                                                                        | 
| Step 6  		     | 	... informing operation success?             | CreateJobUI         | IE: is responsible for user interactions.                                                                     | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* Organization
* Job

Other software classes (i.e. Pure Fabrication) identified: 

* CreateJobUI  
* CreateJobController


## 3.2. Sequence Diagram (SD)



### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us006-sequence-diagram-full.svg)

### Split Diagrams

The following diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses Interaction Occurrence (a.k.a. Interaction Use).

![Sequence Diagram - split](svg/us006-sequence-diagram-split.svg)

**Get Employee**

![Sequence Diagram - Partial - Get Employee](svg/us006-sequence-diagram-partial-get-employee.svg)

**Create Job**

![Sequence Diagram - Partial - Create Job](svg/us006-sequence-diagram-partial-create-task.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us006-class-diagram.svg)