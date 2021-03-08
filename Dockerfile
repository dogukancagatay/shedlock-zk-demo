FROM openjdk:8-jdk-alpine
ENV SPRING_CLOUD_ZOOKEEPER_CONNECT_STRING "zookeeper:2181"
WORKDIR /app
COPY ./ /app/
RUN ./gradlew build --no-daemon
CMD ./gradlew bootRun
