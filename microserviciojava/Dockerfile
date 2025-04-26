FROM openjdk:17-jdk-slim
WORKDIR /app

RUN apt-get update && apt-get install -y wget && \
    wget https://jdbc.postgresql.org/download/postgresql-42.7.3.jar -O postgresql.jar

COPY ./src /app/src
COPY entrypoint.sh /app/entrypoint.sh

RUN javac -cp "postgresql.jar" src/*.java
RUN chmod +x entrypoint.sh

CMD ["./entrypoint.sh"]
