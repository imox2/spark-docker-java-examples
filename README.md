
# Spark Docker Java Examples

This project contains various examples of using Apache Spark with Java, including reading from JSON files and MongoDB. The project is structured to demonstrate different use cases in separate classes.



## Getting Started
### Prerequisites
- Java 17 -
- Docker (optional, for running Spark in a container) -
- Gradle

### Building the Project   To build the project, run the following command:
`./gradlew shadowJar`

This will create a fat JAR with all dependencies included.

## Running Examples

### JSON Read Example

To run the JSON read example:

`java -cp build/libs/spark-docker-java-examples.jar com.spark.examples.JsonReadExample`




## Docker Examples

### Setting up Spark Cluster

1.  Start the Spark master:


`docker run -d --name spark-master -h spark-master -p 8080:8080 bitnami/spark:latest /opt/bitnami/scripts/spark/entrypoint.sh /opt/bitnami/spark/bin/spark-class org.apache.spark.deploy.master.Master`

2.  Start a Spark worker:


`docker run -d --name spark-worker --link spark-master:spark-master -p 8081:8081 bitnami/spark:latest /opt/bitnami/scripts/spark/entrypoint.sh /opt/bitnami/spark/bin/spark-class org.apache.spark.deploy.worker.Worker spark://spark-master:7077`

### Running the Examples in Docker

1.  Build the Docker image for the examples:

`docker build -t spark-java-examples .`

2.  Run the example in Docker:

`docker run --rm --link spark-master:spark-master -p 4040:4040 spark-java-examples`

## Dockerfile

Here's the Dockerfile used for the examples:

    FROM openjdk:17-jdk-slim  
      
    COPY build/libs/spark-docker-java-example.jar /app.jar  
    COPY src/main/resources/people.json /src/main/resources/people.json  
      
    CMD ["java", "--add-opens", "java.base/sun.nio.ch=ALL-UNNAMED", "-cp", "/app.jar", "com.spark.examples.JsonReadExample"]


## Contributing

Feel free to contribute to this project by submitting pull requests or opening issues for any bugs or feature requests.

## License

This project is licensed under the Creative Commons Attribution 4.0 International (CC BY 4.0) License.

You are free to:
- Share: copy and redistribute the material in any medium or format.
- Adapt: remix, transform, and build upon the material for any purpose, even commercially.

Under the following terms:
- Attribution: You must give appropriate credit, provide a link to the license, and indicate if changes were made. You may do so in any reasonable manner, but not in any way that suggests the licensor endorses you or your use.

For more details, see the [license document](https://creativecommons.org/licenses/by/4.0/).
