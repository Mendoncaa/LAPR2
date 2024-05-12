# US007 - Register a vehicle's check-up.
## 3. Design - User Story Realization 

### 3.1. Rationale

| InteractionID                                     | Question: Which class is responsible for…                   | Answer                     | Justification (with patterns)                             |
|---------------------------------------------------|-------------------------------------------------------------|----------------------------|-----------------------------------------------------------|
| Step 1 - Ask to Register a Vehicle for check's up | … interacting with  the actor?                              | Create Check-up UI         | Pure Fabrication                                          |
|                                                   | … Coordinating the US?                                      | Create Check-up Controller | Pure Fabrication (System Interaction Controller)          |
| Step 2 - Requests Data                            | … displaying form for actor input?                          | Create Check-Up UI         | Pure Fabrication (Interaction with actor)                 |
| Step 3 - Types Requested Data                     | … Validating input data?   temporarily keeping input data   | Create Check-Up UI         | Pure Fabrication (Interaction with actor)                 |
| Step 4 - Shows all data and requests Confirmation | … displaying all the information before submitting?         | Create Check-Up UI         | Pure Fabrication (Interaction with actor)                 |
| Step 5 - Confirms data                            | ... Knowing the user using the system?                      | User Session               | IE: see Auth component documentation                      |
|                                                   | … instantiating a new Vehicle (Object)?                     | Organization               | Creator (Rule1): in the DM Organization owns Vehicle List |
|                                                   | … validating all data (Local validation, i.e. mandatory)?   | Vehicle's Check-Up         | IE: owns its data                                         |
|                                                   | … validating all data (Global validation, i.e. duplicates)? | Organization               | IE: knows all its Vehicles's Check up                     |
|                                                   | … saving the created Vehicle's Check-Up?                    | Organization               | IE: owns all its Vehicles's Check-Up                      |
|                                                   | … Saving the inputted data?                                 | Vehicle's Check-Up         | IE: object created previously has its own data            |
| Step 6 - Display operation Success                | … information on operation success?                         | Create Check-Up UI         | Pure Fabrication (Interaction with Actor)                 |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are:

* Organization
* Check up

Other software classes (i.e. Pure Fabrication) identified:

* CreateCheckUpUI
* CreateCheckUpController


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative Two is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![us007-sequence-diagram-full.svg](svg%2Fus007-sequence-diagram-full.svg)



## 3.3. Class Diagram (CD)

![us007-sequence-diagram-full.svg](svg%2Fus007-sequence-diagram-full.svg)