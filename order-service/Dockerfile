FROM openjdk:8-jdk-alpine
EXPOSE 8090
ADD target/product-service-0.0.1-SNAPSHOT.jar order-service.jar
ENTRYPOINT ["sh", "-c", "java -jar /order-service.jar"]