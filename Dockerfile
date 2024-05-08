FROM amazoncorretto:17.0.7-alpine
ADD target/springboot-mongo-docker.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]