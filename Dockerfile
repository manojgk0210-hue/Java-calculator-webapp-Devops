FROM tomcat:10.1-jdk17
COPY target/calculator.war /usr/local/tomcat/webapps/calculator.war
