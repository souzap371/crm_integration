FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/crm-integration.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
