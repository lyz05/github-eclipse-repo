FROM tomcat:7.0

EXPOSE 8080

COPY --from=book /usr/local/tomcat/webapps/book.war /usr/local/tomcat/webapps/book.war
COPY --from=javaweb /usr/local/tomcat/webapps/javaweb.war /usr/local/tomcat/webapps/javaweb.war
COPY --from=ssm-crud /usr/local/tomcat/webapps/ssm-crud.war /usr/local/tomcat/webapps/ssm-crud.war
