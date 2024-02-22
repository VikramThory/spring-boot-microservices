FROM openjdk:21-jdk-slim

MAINTAINER vikramthory

COPY target/loans-0.0.1-SNAPSHOT.jar loans-0.0.1-SNAPSHOT.jar

#docker build . -t vikramthory/accounts:0.0.1
ENTRYPOINT ["java", "-jar", "loans-0.0.1-SNAPSHOT.jar"]