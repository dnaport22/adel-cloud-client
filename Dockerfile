FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./build/libs/ga-rest-api-0.1.0.jar /usr/src/app/
WORKDIR /usr/src/app
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","ga-rest-api-0.1.0.jar"]