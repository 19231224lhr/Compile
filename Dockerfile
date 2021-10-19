FROM openjdk:14
COPY ./ /app/
WORKDIR /app/
RUN javac src/*.java -d ./
