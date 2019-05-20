FROM java:8
MAINTAINER songang
RUN mkdir /app
WORKDIR /app
COPY build/libs/eureka-server-0.0.1-SNAPSHOT.jar .
RUN mv eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "eureka-server.jar"]
