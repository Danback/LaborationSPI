FROM maven:3.9.6-eclipse-temurin-22-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM eclipse-temurin:22-jre-alpine
WORKDIR /app
COPY --from=build /app/module-api/target/module-api-1.0-SNAPSHOT.jar ./module-api.jar
COPY --from=build /app/module-main/target/module-main-1.0-SNAPSHOT.jar ./module-main.jar
COPY --from=build /app/module-fixed/target/module-fixed-1.0-SNAPSHOT.jar ./module-fixed.jar
COPY --from=build /app/module-variable/target/module-variable-1.0-SNAPSHOT.jar ./module-variable.jar

CMD ["java", "--module-path", ".", "--module", "com.laborationSPI.springboot.main/com.laborationSPI.springboot.main.Main"]