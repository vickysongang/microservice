FROM java:8
MAINTAINER songang

RUN mkdir /app
WORKDIR /app
COPY build/libs/config-server-0.0.1-SNAPSHOT.jar .
RUN mv config-server-0.0.1-SNAPSHOT.jar config-server.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "config-server.jar"]
EXPOSE 9009