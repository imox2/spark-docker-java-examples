FROM openjdk:17-jdk-slim

COPY build/libs/spark-docker-java-example.jar /app.jar
COPY src/main/resources/people.json /src/main/resources/people.json

CMD ["java", "--add-opens", "java.base/sun.nio.ch=ALL-UNNAMED", "-cp", "/app.jar", "com.spark.examples.JsonReadExample"]
