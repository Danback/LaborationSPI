FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml ./
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean install

FROM openjdk:17-slim

WORKDIR /app

COPY --from=build /app/target/module-api-1.0-SNAPSHOT.jar ./module-api.jar
COPY --from=build /app/target/module-fixed-1.0-SNAPSHOT.jar ./module-fixed.jar
COPY --from=build /app/target/module-variable-1.0-SNAPSHOT.jar ./module-variable.jar
COPY --from=build /app/target/module-main-1.0-SNAPSHOT.jar ./module-main.jar

CMD ["java", "--module-path", ".", "--module", "com.laborationSPI.springboot.main/com.laborationSPI.springboot.main.Main"]