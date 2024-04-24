# US007 - Register a vehicle's check-up.


## 1. Requirements Engineering
### 1.1. User Story Description

_US07 - As an FM,I wish to register a vehicle's check-up._

### 1.2. Customer Specifications and Clarifications 
**From the specifications document:**
> VFM requires a feature that allows to record when a vehicle undergoes a check-up.

**From the client clarifications:**

> **Question:** Should the application identify a registered vehicle by a serial number or other attribute?
>
> **Answer:** By plate id;

> **Question:** Does a vehicle need to be registered in US06 before being able to go for a check up in US07?
> 
>  **Answer:** yes.

> **Question:** (...) which attributes will you need for the vehicle's check-up? (...)
>
> **Answer:** Plate number, date, kms at checkup

### 1.3. Acceptance Criteria

* **AC1 -** All input data of the form must be filled before submitting the vehicle's check up.
* **AC2 -** Check's up date cannot be registered after the current date.
* **AC3 -** The system allows the FM to register a vehicle’s check-up.

### 1.4. Found out Dependencies

US007 depends on US006 - "As an FM, I wish to register a vehicle (...)".

It's necessary to have a vehicle registered into the system 
before register the vehicle's check up.

### 1.5 Input and Output Data

**Input data:**
* Typed Data:
  * Vehicle's ID;
  * Schedule's date;
  * Current Km's;

**Output data**
* (In)Success of the operation;



### 1.6. System Sequence Diagram (SSD)

_Insert here a SSD depicting the envisioned Actor-System interactions and throughout which data is inputted and outputted to fulfill the requirement. All interactions must be numbered._

![USXXX-SSD](svg/usXXX-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks
 [n/a]