FROM openjdk:11
EXPOSE 9090
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} employee-mysql-docker.jar
ENTRYPOINT ["java","-jar","/employee-mysql-docker.jar"]
