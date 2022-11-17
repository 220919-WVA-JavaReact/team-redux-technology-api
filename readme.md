# Minecraft Store API

[![GitHub license](https://img.shields.io/github/license/Naereen/StrapDown.js.svg)](https://github.com/Naereen/StrapDown.js/blob/master/LICENSE)


### By: Team Redux
#### [Jonny Andino](https://github.com/bluephosphor) | [Lesly Gonzalez](https://github.com/leslyr562) | [Roger Chau](https://github.com/RaventiGIT) | [Lilith Ryder](https://github.com/Hek80)

---

## What is it?

The backend for our Minecraft Shop! This API takes in requests sent from our UI, processes those requests and sends back the appropriate responses.
This API also serves as the connection to our database.  So it is in charge of retrieving and persisting new information to the database.

## Technologies
- Java
  - The core programming language of our application. The Object-Oriented nature of Java allowed us to modularize our application and keep track of the logic in a concise and readable manner.
- Maven
  - Our build system: Maven allowed us to package our application for development, testing and finally deployment.
- Spring Boot
  - Built to jump start the development process, Boot allowed us to start development of core functionality much sooner with its opinionated approach to Java Application development.

## API Routes
- API Route information can be found at here in the [UI repo notes](https://github.com/220919-WVA-JavaReact/team-redux-technology-ui/tree/main/notes/api-routes)

## Run:
- Clone the repo
- if using Intellij
  - Load up the project and navigate to `src.main.java.com.revature`
  - Run the `main()` method of `MinecraftStoreApplication`

## Build:
- Clone the repo
- run `mvn clean package -Pprod`
### Run the build:
- run `cd target`
- run `java -jar minecraft-store-0.0.1-SNAPSHOT.jar`