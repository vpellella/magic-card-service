FROM maven:3.8.2-amazoncorretto-8 as builder
WORKDIR /usr/app/magic-card
COPY . .
RUN mvn clean install

From amazoncorretto:8-alpine-jre
WORKDIR /usr/app/magic-card/service/
COPY --from=builder /usr/app/magic-card/target/MagicCard-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "MagicCard-0.0.1-SNAPSHOT.jar"]
