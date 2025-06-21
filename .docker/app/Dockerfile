FROM eclipse-temurin:17.0.11_9-jre
RUN mkdir /opt/app
COPY ./build/libs/*.jar /opt/app/app.jar
CMD ["java", "-Dspring.profiles.active=mock", "-jar", "/opt/app/app.jar"]