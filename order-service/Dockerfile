FROM maven:3.9-eclipse-temurin-21 AS build
LABEL author="yefrosiniya.zinkovskaya"
WORKDIR /app
COPY pom.xml .
COPY order-service/pom.xml order-service/
COPY notification-service/pom.xml notification-service/
COPY order-service/src order-service/src
RUN mvn -pl order-service -am -DskipTests package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/order-service/target/order-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
