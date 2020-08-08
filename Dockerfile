FROM openjdk:13-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} hlv.jar
ENTRYPOINT ["java","-jar","/hlv.jar"]