FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/micro_departamentos-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8002

CMD ["java", "-jar", "app.jar"]
