FROM openjdk:8-jre-slim
VOLUME /tmp
COPY ./build/libs/ga-rest-api-0.1.0.jar /usr/src/app/
COPY ./credentials.json /usr/src/app/
COPY ./device_instance.json /usr/src/app/
COPY ./device_model.json /usr/src/app/
WORKDIR /usr/src/app
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","ga-rest-api-0.1.0.jar"]