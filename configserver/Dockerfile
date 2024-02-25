FROM openjdk:21-jdk-slim

MAINTAINER vikramthory

COPY target/configserver-0.0.1-SNAPSHOT.jar configserver-0.0.1-SNAPSHOT.jar

#docker build . -t vikramthory/configserver:0.0.1
ENTRYPOINT ["java", "-jar", "configserver-0.0.1-SNAPSHOT.jar"]