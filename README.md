# Evaluating Micronaut Part 1

Application Architecture:

![Application - version 8](micronaut-arc.png)


-	Trivia microservices is responsible for sending the event, storing data, checking attempts and generate result. It uses hibernate as a data access layer.

-	Gamification microservices manages all gamification busing logic and including checking the result, assign points, assign badges and updates the highest score board. It uses MongoDB for data storage.


Web UI:

![Application - version 8](micronaut-app-ui.png)