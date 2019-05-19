FROM java:8
MAINTAINER songang

RUN mkdir /app
WORKDIR /app
COPY build/libs/config-client-0.0.1-SNAPSHOT.jar .
RUN mv config-client-0.0.1-SNAPSHOT.jar config-client.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "config-client.jar"]
EXPOSE 9010