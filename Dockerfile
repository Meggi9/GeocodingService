FROM openjdk:17
ADD target/GeocodingService-0.0.1-SNAPSHOT.jar GeocodingApp.jar
ENTRYPOINT ["java", "-jar", "GeocodingApp.jar"]