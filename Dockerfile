FROM openjdk:8
ADD target/price-engine-0.0.1-SNAPSHOT.jar price-engine-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "price-engine-0.0.1-SNAPSHOT.jar"]