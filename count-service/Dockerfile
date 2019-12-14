FROM openjdk:13-alpine
LABEL maintainer="Peter Segal <pesegal@gmail.com>"

ARG JAR_FILE
ADD ${JAR_FILE} /service/service.jar

ENTRYPOINT ["java", "-jar", "/service/service.jar"]