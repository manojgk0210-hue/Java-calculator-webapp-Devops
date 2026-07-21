FROM tomcat:10.1-jdk21

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/calculator.war /usr/local/tomcat/webapps/calculator.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
