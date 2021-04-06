FROM openjdk:8-jdk-alpine
EXPOSE 8091
ADD target/product-service-0.0.1-SNAPSHOT.jar bulk-order-processing-service.jar
ENTRYPOINT ["sh", "-c", "java -jar /bulk-order-processing-service.jar"]