FROM java:8
MAINTAINER songang

RUN mkdir /app
WORKDIR /app
COPY build/libs/service-gateway-0.0.1-SNAPSHOT.jar .
RUN mv service-gateway-0.0.1-SNAPSHOT.jar service-gateway.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "service-gateway.jar"]
EXPOSE 9011