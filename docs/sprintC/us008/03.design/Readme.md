# US008 - List the Vehicles Needing the Check-up

## 3. Design - User Story Realization

### 3.1. Rationale



| Interaction ID | Question: Which class is responsible for...          | Answer                     | Justification (with patterns)                                                                                 |
|----------------|------------------------------------------------------|----------------------------|---------------------------------------------------------------------------------------------------------------|
| Step 1         | ... interacting with the actor?                      | ListVehiclesCheckupUI      | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
|                | ... coordinating the US?                             | ListVehiclesCheckupController | Controller: Manages the flow between the user interface and the service layer.                                |
|                | ... gathering and processing vehicle data?           | VehicleService             | Creator: Responsible for creating team instances based on given criteria.                                     |
|                | ... accessing and retrieving vehicle data?           | VehicleRepository          | Pure Fabrication: technical abstraction that facilitates vehicles management.                                 |
| Step 2         | ... presenting the list of vehicles needing check-up?| ListVehiclesCheckupUI      |                                                                                                               |

### Systematization

According to the taken rationale, the conceptual classes promoted to software classes are:

- Vehicle

Other software classes (i.e. Pure Fabrication) identified: 

- VehicleService
- VehicleRepository
- ListVehiclesCheckupUI  
- ListVehiclesCheckupController

## 3.2. Sequence Diagram (SD)


### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us08-sequence-diagram.svg)


## 3.3. Class Diagram (CD)

![Class Diagram](svg/us08-class-diagram.svg)
