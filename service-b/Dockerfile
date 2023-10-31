#FROM openjdk:17-jdk AS build
#WORKDIR /service-b
#COPY ./service-b/build.gradle .
#COPY ./service-b/settings.gradle .
#COPY ./service-b/src src
#COPY ./service-b/gradlew .
#COPY ./service-b/gradle/ gradle/
#COPY agent agent
#RUN ./gradlew build

FROM openjdk:17-jdk
COPY ./service-b/build/libs/service-b-0.0.1-SNAPSHOT.jar /app.jar
COPY agent /agent
ENTRYPOINT ["java", "-javaagent:/agent/opentelemetry-javaagent.jar", "-Dotel.javaagent.configuration-file=/agent/otel.properties", "-jar", "/app.jar"]
