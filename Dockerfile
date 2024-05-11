FROM openjdk:17-oracle
COPY target/ms-settings.jar ms-settings.jar
EXPOSE 8010
ENTRYPOINT ["java", "-jar", "/ms-settings.jar"]