FROM openjdk:15
COPY ./ /app/
WORKDIR /app/
RUN javac src/*.java -d ./
