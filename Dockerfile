FROM openjdk:11
EXPOSE 9090
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} employeeService.jar
ENTRYPOINT ["java","-jar","/employeeService.jar"]
