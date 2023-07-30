# Name: Jimmy Tran
# G#: G01130635
# Name: Jacob Groen
# G#: G01149885
# Name: Kelvin Lu
# G#: G01194210
# Course-Section: SWE645-001
# Assignment: #3
# Dockerfile used for building our docker image with web app.

FROM openjdk:17-alpine

WORKDIR /app
COPY ./target/surveyApp-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "/app/surveyApp-0.0.1-SNAPSHOT.jar"]