FROM openjdk:21-jdk-slim

MAINTAINER vikramthory

COPY target/eurekaserver-0.0.1-SNAPSHOT.jar eurekaserver-0.0.1-SNAPSHOT.jar

#docker build . -t vikramthory/eurekaserver:0.0.1
ENTRYPOINT ["java", "-jar", "eurekaserver-0.0.1-SNAPSHOT.jar"]