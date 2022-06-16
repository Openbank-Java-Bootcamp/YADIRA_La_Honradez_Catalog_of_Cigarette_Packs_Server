# Royal Cigarette Factory "La Honradez" (Server)
### CATALOG OF CIGARETTE PACKS
by Yadira Calzadilla

## Description of the project
The project consists of a demo of a catalog of collector's items (cigarette packs), belonging to the La Honradez factory. Each piece belongs to a series, and it deals with different topics. In addition, there are articles that delve into this topic and that can be consulted on the internet. The application also provides access to them.

## Agile Methodologies
For the implementation of the project, guidelines of the agile methodology were followed. For more information you can consult the following trello scheme: https://trello.com/b/69DxjPM4/la-honradez-final-proyect. 

For this demo only the following user stories were taken into account in the backlog:
- As an unregistered user I can access the main page and consult general information about the La Honradez factory and its cigarette packs.
- As a registered user I can access the collection of cigarette packs and carry out searches filtered by the name of the series to which they belong and by topic.
- As a registered user I can access the list of articles published on the internet that delve into the subject.
- As an administrator I can add, delete and modify cigarette packs.
- As an administrator I can add, delete and modify articles.

## Technologies
In the architecture of the project, Spring Boot was used for communication with the front application, deployed in React. Hibernate & JPA were also used for the deployment of models and communication with databases.

![USE CASES DIAGRAM](https://user-images.githubusercontent.com/100872227/174071243-46973f4b-737b-42a9-b3d9-213e28de1325.png)

![CLASSES DIAGRAM](https://user-images.githubusercontent.com/100872227/174057669-5382062d-8b39-47ab-9935-bd10ac0d4bef.png)

## Endpoints and details
![enpoints](https://user-images.githubusercontent.com/100872227/174070250-65e8a79e-adcd-4c5c-b2ec-11cafbb1339d.jpg)

![auth endpoint](https://user-images.githubusercontent.com/100872227/174070300-e4bb9b56-7d7a-4a52-a970-66f67367a744.jpg)

![cigpack enpoints](https://user-images.githubusercontent.com/100872227/174070343-664e07bc-db1e-432d-b364-f4712c617c72.jpg)

![serie endpoint](https://user-images.githubusercontent.com/100872227/174070382-a49a8a18-4a69-49fd-9c35-40c6d0d48ea9.jpg)

![topic endpoint](https://user-images.githubusercontent.com/100872227/174070408-c1af223b-b374-477b-a282-8c39c4b12adc.jpg)

![article endpoint](https://user-images.githubusercontent.com/100872227/174070465-97563f66-7696-4bbd-aa09-a7e23525f0a4.jpg)

## Future Work
Continue with the development of the application, adding more options, endpoints to add series and topics, as well as the possibility of editing them.

Opt for a responsive design that allows a better user experience from devices of various sizes.

## Access to the Front aplication
https://github.com/Openbank-Java-Bootcamp/YADIRA_La_Honradez_Catalog_of_Cigarette_Packs_Client

