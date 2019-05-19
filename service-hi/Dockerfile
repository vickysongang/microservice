FROM java:8
MAINTAINER songang

RUN mkdir /app
WORKDIR /app
COPY build/libs/service-hi-0.0.1-SNAPSHOT.jar .
RUN mv service-hi-0.0.1-SNAPSHOT.jar service-hi.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "service-hi.jar"]
EXPOSE 8080