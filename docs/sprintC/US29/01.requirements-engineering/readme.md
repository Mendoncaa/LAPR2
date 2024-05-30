# US020 - Register a Green Space

## 1. Requirements Engineering

### 1.1. User Story Description

As a Green Space Manager (GSM), I want to register a green space (garden, medium-sized park, or large-sized park) and its respective area.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

> The responsibility for registering a green space relies on the GSM, who must introduce the name, size classification, area (in hectares), and address.

**From the client clarifications:**

> **Question:** Good evening, in view of the description of GreenSpaces does it make sense to ask for optional mind for the different types this data?
>
> **Answer:** In the current version, it is sufficient to define a park using name, size classification, area (hectare), and address.

> **Question:** Good afternoon, I would like to know between what ranges of hectares a green space is classified as garden, medium or large, or if it is possible to register 2 green spaces with the same area but in different typology, depending on the GSM it registers.
>
> **Answer:** The classification is not automatic, it's up to GSM decide about it.

> **Question:** Can two green spaces have the same name?
>
> **Answer:** No.

> **Question:** Our team is unsure about what the exact inputs for the Green Space, To-Do List Entry, and Agenda entry exactly are.
>
> **Answer:** Seems enough.

### 1.3. Acceptance Criteria

* **AC1** The name, size classification, area, and address of the green space need to be supplied by the GSM.

* **AC2** Two green spaces cannot have the same name.

* **AC3** The system should store the green space details provided by the GSM.

### 1.4. Found out Dependencies

There is a dependency on:

* None identified explicitly, but the module should integrate smoothly with the overall system managing green spaces.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
  - Name of the green space
  - Area (in hectares)
  - Address

* Selected data:
   - Size classification (garden, medium-sized park, large-sized park)

**Output Data:**

* Confirmation message indicating successful registration of the green space
* Error message if the name already exists

### 1.6. System Sequence Diagram (SSD)

