# AWS Lambda Java Example

This project demonstrates how to create a Java-based AWS Lambda function using Maven.

## Build

```bash
mvn clean package
```

## Deploy to AWS Lambda

- Upload the generated JAR from `target/` to AWS Lambda.

## Handler Format

```
com.example.LambdaHandler::handleRequest
```

## Requirements

- Java 11+
- Maven
- AWS CLI configured
