FROM maven:3.5.4-jdk-8-alpine as build
COPY . .
RUN mvn clean package -DskipTests


FROM tomcat:7.0

EXPOSE 8080
COPY --from=build target/book-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/book.war