package com.spark.examples;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class JsonReadExample {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("Java Spark Example")
                .master("local[*]")
                .getOrCreate();

        Dataset<Row> data = spark.read().json("src/main/resources/people.json");

        data.show();

        spark.stop();
    }
}

