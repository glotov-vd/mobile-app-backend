FROM gradle:8.12.0-jdk17-alpine AS build

WORKDIR /app

COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src

RUN gradle build --no-daemon --refresh-dependencies


FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]