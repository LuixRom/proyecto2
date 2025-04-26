FROM openjdk:17-jdk-slim
WORKDIR /app
RUN apt-get update && apt-get install -y wget && \
    wget https://jdbc.postgresql.org/download/postgresql-42.7.3.jar -O postgresql.jar

COPY ./src /app/src
RUN javac -cp "postgresql.jar" src/*.java

CMD java -cp ".:postgresql.jar:src" app && java -cp ".:postgresql.jar:src" Seeder
