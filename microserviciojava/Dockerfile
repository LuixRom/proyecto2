FROM openjdk:17-jdk-slim

WORKDIR /app

RUN apt-get update && apt-get install -y wget && \
    wget https://jdbc.postgresql.org/download/postgresql-42.7.1.jar -O postgresql.jar

COPY ./src /app/src

RUN javac -cp "postgresql.jar" src/*.java

CMD ["sh", "-c", "java -cp postgresql.jar:src src.app & sleep 10 && java -cp postgresql.jar:src src.Seeder"]
