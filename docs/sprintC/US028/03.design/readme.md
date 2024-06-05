# US020 - Register a Green Space

## 3. Design - User Story Realization 

# US020 - Register a Green Space

## 3. Design - User Story Realization 

### 3.1. Rationale

| Interaction ID                             | Question: Which class is responsible for...                 | Answer                   | Justification (with patterns)                                                                       |
|:-------------------------------------------|:------------------------------------------------------------|:-------------------------|:----------------------------------------------------------------------------------------------------|
| Step 1 - requests to register a green space| ... interacting with the actor?                             | RegisterGreenSpaceUI     | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the DM. |
|                                            | ... coordinating the US?                                    | RegisterGreenSpaceController | Pure Fabrication (System Interaction Controller)                                                     |
| 			                                    | ... knowing the user using the system?                      | UserSession              | IE: see Auth component documentation.                                                               |        
| Step 2 - requests data                     | ... displaying form for actor input?                        | RegisterGreenSpaceUI     | Pure Fabrication (Interaction with Actor)                                                             |
| Step 3 - types requested data              | ... temporally keeping input data?                          | RegisterGreenSpaceUI     | Pure Fabrication (Interaction with Actor)                                                             | 
| Step 4 - show green space data and request confirmation | ... displaying all the information before submitting?       | RegisterGreenSpaceUI     | Pure Fabrication (Interaction with Actor)                                                             |
| Step 5 - confirms data                     | ... instantiating a new GreenSpace (Object)?                | GreenSpace               | Creator (Rule 1): in the DM GreenSpace owns its data.                                       |
|                                            | ... validating all data (local validation,e.g. mandatory)?  | GreenSpace               | IE: owns its data.                                                                                  |
|                                            | ... validating all data (global validation,e.g. duplicates)?| GreenSpaceRepository     | IE: knows all GreenSpaces.                                                                        |
|                                            | ... saving the green space?                                 | GreenSpaceRepository     | IE: owns all GreenSpaces.                                                                         |
| Step 6 - display operation success         | ... informing operation success?                            | RegisterGreenSpaceUI     | Pure Fabrication (Interaction with Actor)                                                              |              

### Systematization

According to the taken rationale, the conceptual classes promoted to software classes are: 

* GreenSpace

Other software classes (i.e. Pure Fabrication) identified: 

* RegisterGreenSpaceUI  
* RegisterGreenSpaceController
* UserSession
* GreenSpaceRepository


