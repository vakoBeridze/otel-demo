FROM gradle:7-jdk11 AS build
WORKDIR /service-a
COPY ./service-a/src src
COPY ./service-a/build.gradle .
COPY agent agent
RUN gradle build --no-daemon

FROM openjdk:11-jre-slim
COPY --from=build /service-a/build/libs/service-a-0.0.1-SNAPSHOT.jar /app.jar
COPY --from=build /service-a/agent /agent
ENTRYPOINT ["java", "-javaagent:/agent/opentelemetry-javaagent.jar", "-Dotel.javaagent.configuration-file=/agent/otel.properties", "-Dotel.service.name=service-a", "-jar", "/app.jar"]
