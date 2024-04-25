FROM openjdk:22-ea-10-jdk-slim AS build

WORKDIR /app

COPY pom.xml .

COPY src /app/src


RUN mvn clean package


FROM openjdk:22-ea-10-jre-slim

COPY --from=build /app/module1/target/module1.jar /app
COPY --from=build /app/module2/target/module2.jar /app
COPY --from=build /app/module3/target/module3.jar /app

WORKDIR /app


CMD ["java", "-jar", "module1.jar"]
