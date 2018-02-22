FROM tomcat:9.0-jre8-alpine
COPY ["target/base-war-deployment-unit-1.0-SNAPSHOT.war","/usr/local/tomcat/webapps"]
COPY ["tomcat/server.xml","/usr/local/tomcat/conf/server.xml"]
COPY ["tomcat/tomcat-users.xml","/usr/local/tomcat/conf/tomcat-users.xml"]
EXPOSE 8080
CMD ["catalina.sh","run"]
