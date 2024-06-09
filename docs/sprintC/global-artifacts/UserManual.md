# User Manual

## Development of an Urban Green Spaces Management Software Solution

### Degree in Computer Engineering 
### LAPR2 – 2023/2024


Authors:
- Flávio Cruz (1010488)
- Pedro Morgado (1130277)
- Ricardo Teixeira (1181885)

Class: 1NB

Group: G322 (CodeGardeners)

Date: 11/04/2024


## Contents

- Glossary
- Introduction
- System Overview
- Features 
    

## [Glossary](01.requirements-engineering/glossary.md)

## Introduction

The purpose of this manual is to provide comprehensive guidance on
the utilization of the application, developed for the management of
urban parks. It aims to offer user clear instructions on navigating
and harnessing the full potential of the application's functionalities.


The application aims to optimize various aspects of park management,
including team coordination and management, resource allocation, generation of statistical reports,
and user communication. Therefore, it is a software product
specifically tailored to address the needs of park administrators,
maintenance personnel, and park users.

The manual is addressed to a diverse range of users involved in
the management and utilization of urban parks. These users may
include:

* **Park Administrators:** Individuals responsible for overseeing the
  planning, maintenance, and overall management of urban parks.


* **Maintenance Personnel:** Workers with responsibilities for maintenance activities within
  the park, such as gardening, landscaping, and infrastructure upkeep.


* **Park Users:** Individuals who visit and use the urban parks for
  recreational purposes. This may include families, joggers,
  picnickers, and other members of the community.


* **Technical Support Staff:** Personnel responsible for providing
  assistance and troubleshooting issues related to the application's
  usage and functionality.

## System Overview

The objectives of the application are aligned with addressing
needs associated with the management of urban parks.
Here are the primary objectives of the application, as seen also in figure 1:

1. **Enhanced Team Coordination:** The application facilitates
   effective coordination and communication among multi-professional
   teams involved in park maintenance activities. It provides tools
   for task assignment, scheduling, and collaboration, ensuring that
   teams work cohesively towards common objectives.


2. **Optimization of Infrastructure Systems:** One of the key objectives
   is to optimize infrastructure systems within urban parks, such as
   irrigation and lighting systems. The application offers
   functionalities to program and control these systems efficiently,
   ensuring optimal utilization of resources while minimizing waste.


3. **Performance Evaluation and Reporting:** Another objective is to
   enable park administrators to assess the performance of park
   management activities through the generation of statistical
   reports and performance indicators. These reports provide
   valuable insights into the effectiveness of maintenance
   efforts and help in making informed decisions for future planning.


4. **User Engagement and Feedback:** The application aims to foster
   greater engagement with park users by providing a dedicated
   portal for reporting faults or malfunctions of equipment. This
   feature allows park administrators to address issues promptly,
   thereby enhancing the overall user experience and satisfaction.


5. **Efficient Resource Management:** The application aims to streamline
   the allocation and utilization of resources within urban parks,
   including personnel, vehicles, machinery, and equipment.
   By optimizing resource allocation, the application helps in
   enhancing operational efficiency and reducing costs.


By achieving these objectives, the application contributes to
the effective and sustainable management of urban parks,
ultimately enhancing the quality of life for park users and
communities.

![img_1.png](img_1.png)
*Figure 1 - Primary objectives of the application*

# Features


| **Number** | **Functionality**                           | Description                                                                                                                | User                            |
|------------|---------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|---------------------------------|
| **1**      | **Register a skill**                        | Create a skill by selecting functionality and inserting asked data.                                                        | Human Resources Manager(HRM)    |
| **2**      | **Register a job**                          | Create a job by selecting functionality and inserting asked data.                                                          | Human Resources Manager(HRM)    |
| **3**      | **Register a collaborator**                 | Create a collaborator by selecting functionality and inserting asked data ans choosing a Job from a list.                  | Human Resources Manager(HRM)    |
| **4**      | **Assign skills to a collaborator**         | Selecting functionality to choose a collaborator and assign one or more skills from a list.                                | Human Resources Manager(HRM)    |
| **5**      | **Generate a team automatically**           | Selecting this functionality a team will be created with skills and number of collaboratores inserted                      | Human Resources Manager(HRM)    |
| **6**      | **Register a vehicle**                      | Create a vehicle by selecting functionality and inserting asked data.                                                      | Vehicle Fleet Manager(VFM)      |
| **7**      | **Register vehicle maintenance**            | Selecting this functionality will be asked by maintenance data and update that information.                                | Vehicle Fleet Manager(VFM)      |
| **8**      | **List vehicles needing maintenance**       | Functionality that lists vehicles that need maintenance appointment.                                                       | Vehicle Fleet Manager(VFM)      |
| **9**      | **Water consumption costs in Green Spaces** | Functionality that calculates water consumption costs reading a file given by GSM with water consumptions.                 | Green Spaces Manager(GSM)       |
| **10**     | **Equipment Use**                           | Creates a pie chart with percentages of used of a Green Space inputing a file with individual equipment uses.              | Green Spaces Manager(GSM)       |
| **11**     | **Park Use by age**                         | Generate a graph age organized with park uses and if is recommended to other users with a inputted PortalUser information | Green Spaces Manager(GSM)       |
| **12**     | **Import "csv" file**                       | Data import from a file that contains water points connections and associated distance                                    | Green Spaces Manager(GSM)       |
| **13**     | **Create water route**                      | Functionality that returns the routes to be opened and pipes needed to be laid with a minimum accumulated cost             | Green Spaces Manager(GSM)       |
| **14**     | **Execution time tests**                    | This action runs a series of tests to see how inputs affects execution times in a algorithm                                | Quality Assurance Manager (QAM) |


# Troubleshooting

1. Problem: The user cannot register a new skill.
* Possible Cause: Mandatory fields not filled in correctly or lack of access permissions.
* Possible Solution: Check if all mandatory fields are filled in correctly. Ensure that the user has the appropriate permissions to access this functionality.

2. Problem: When trying to create a new job, the system displays an error message.
* Possible Cause: Data entered outside acceptable parameters or conflict with other existing jobs.
* Possible Solution: Check if the entered data is correct. Make sure there are no conflicts with other existing jobs in the system.

3. Problem: The collaborator cannot be registered in the system.
* Possible Cause: Mandatory fields not filled in or collaborator not assigned to an existing job.
* Possible Solution: Ensure that all mandatory fields are filled in. Make sure the collaborator has been assigned to an existing job.

4. Problem: Assigning skills to a collaborator is not working.
* Possible Cause: Collaborator not correctly registered or skills unavailable for assignment.
* Possible Solution: Check if the collaborator is correctly registered in the system. Make sure the selected skills are available for assignment.

5. Problem: When generating a team automatically, the system crashes.
* Possible Cause: Parameters entered incorrectly or data conflicts.
* Possible Solution: Check if the parameters for automatic team generation are correct. Make sure there are no data conflicts that could cause the system to crash.

6. Problem: Vehicle registration is not completed.
* Possible Cause: Mandatory fields not filled in correctly or duplication of records.
* Possible Solution: Check if all mandatory fields are filled in correctly. Make sure there is no duplication of records for the same vehicle.

7. Problem: The list of vehicles needing maintenance is not displayed correctly.
* Possible Cause: Maintenance data not updated correctly or an issue with the listing functionality.
* Possible Solution: Correctly update the maintenance data of the vehicles in the system. Check if the listing functionality is working correctly.

8. Problem: When calculating water consumption costs, the results are incorrect.
* Possible Cause: Incorrect water consumption data or erroneous calculations.
* Possible Solution: Check if the water consumption data is correct. Make sure the calculations follow the correct formulas and parameters.

9. Problem: The generation of a graph showing park usage by age is not done correctly.
* Possible Cause: Incorrect park user data or erroneous graph configuration parameters.
* Possible Solution: Check if the park user data is correctly entered in the system. Ensure that the parameters for generating the graph are correctly configured.

# FAQs

* a) Question: I can't log in the system.

* Answer: Check if you are using the correct credentials. If you forgot your password, use the password recovery option provided on the login page. Also, make sure you are entering your username and password correctly, paying attention to uppercase and lowercase letters.


* b) Question: I can't exit the software.

* Answer: Look for the exit button or option in the software interface. It's usually located in configuration menus or under a profile icon. If you can't find it, you can close the software by clicking the "X" button in the top right corner of the window.


* c) Question: How can I download the software?

* Answer: The download process may vary depending on the operating system and the source of the software. Typically, you can find a download link on the official product website. Click on the download link and follow the provided instructions to complete the installation process.
