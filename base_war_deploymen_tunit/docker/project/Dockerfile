FROM tomcat:9.0-jre8-alpine
COPY ["../../target/base-war-deployment-unit-1.0-SNAPSHOT.war","/usr/local/tomcat/webapps"]
COPY ["tomcat/manager.xml","$CATALINA_HOME/conf/Catalina/localhost/"]
COPY ["tomcat/tomcat-users.xml","/usr/local/tomcat/conf/tomcat-users.xml"]
CMD ["catalina.sh","run"]
