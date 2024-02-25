FROM openjdk:21-jdk-slim

MAINTAINER vikramthory

COPY target/cards-0.0.1-SNAPSHOT.jar cards-0.0.1-SNAPSHOT.jar

#docker build . -t vikramthory/cards:0.0.1
ENTRYPOINT ["java", "-jar", "cards-0.0.1-SNAPSHOT.jar"]