FROM openjdk:11-jre
ENV APP_HOME=/apps
WORKDIR $APP_HOME
COPY ./employee-service*.jar ./employee.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar"]
CMD ["employee.jar"]