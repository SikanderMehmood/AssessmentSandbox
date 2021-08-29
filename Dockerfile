FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE="/build/libs";
COPY build/libs/elixir-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]