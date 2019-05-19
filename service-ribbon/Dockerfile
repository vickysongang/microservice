FROM java:8
MAINTAINER songang

RUN mkdir /app
WORKDIR /app
COPY build/libs/service-ribbon-0.0.1-SNAPSHOT.jar .
RUN mv service-ribbon-0.0.1-SNAPSHOT.jar service-ribbon.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "service-ribbon.jar"]
EXPOSE 9000