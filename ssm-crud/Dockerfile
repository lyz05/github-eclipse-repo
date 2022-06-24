FROM maven:3.5.4-jdk-8-alpine as build
COPY . .
RUN mvn clean package -DskipTests


FROM tomcat:7.0

EXPOSE 8080
COPY --from=build target/*.war /usr/local/tomcat/webapps/ssm-crud.war