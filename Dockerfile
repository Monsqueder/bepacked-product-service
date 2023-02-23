FROM gradle:8-alpine as builder
USER root
WORKDIR /builder
ADD . /builder
RUN gradle build --stacktrace

FROM openjdk:17
WORKDIR /app
EXPOSE 8080
COPY --from=builder /builder/build/libs/product-service-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]