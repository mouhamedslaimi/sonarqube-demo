FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /opt/app

ARG JAR_FILE=target/sonarqube-demo.jar

COPY ${JAR_FILE} sonarqube-demo.jar

ENTRYPOINT ["java","-jar","sonarqube-demo.jar"]
