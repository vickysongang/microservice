FROM java:8
MAINTAINER songang

RUN mkdir /app
WORKDIR /app
COPY build/libs/service-zuul-0.0.1-SNAPSHOT.jar .
RUN mv service-zuul-0.0.1-SNAPSHOT.jar service-zuul.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "service-zuul.jar"]
EXPOSE 9002