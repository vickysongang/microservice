FROM java:8
MAINTAINER songang

RUN mkdir /app
WORKDIR /app
COPY build/libs/service-feign-0.0.1-SNAPSHOT.jar .
RUN mv service-feign-0.0.1-SNAPSHOT.jar service-feign.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "service-feign.jar"]
EXPOSE 9001