FROM openjdk:11-jre
ENV APP_HOME=/apps
WORKDIR $APP_HOME
COPY ./department-service*.jar ./department.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar"]
CMD ["department.jar"]