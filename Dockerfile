FROM maven:3.6.3-jdk-11

COPY . /usr/src/myapp

WORKDIR /usr/src/myapp

RUN mvn clean package

FROM openjdk:11-jre-slim

COPY --from=0 /usr/src/myapp/target/*.jar /usr/app/myapp.jar

WORKDIR /usr/app


CMD ["java", "-jar", "myapp.jar"]
