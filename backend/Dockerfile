FROM adoptopenjdk/openjdk11 AS builder
<<<<<<< HEAD

COPY gradlew .

COPY gradle gradle

COPY build.gradle .

COPY settings.gradle .

COPY src src

RUN chmod +x ./gradlew

RUN ./gradlew bootJAR

FROM adoptopenjdk/openjdk11

COPY --from=builder build/libs/*.jar app.jar

EXPOSE 5000

ENTRYPOINT ["java", "-jar", "/app.jar"]
=======
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJAR

FROM adoptopenjdk/openjdk11
COPY --from=builder build/libs/*.jar app.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "/app.jar"]
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
