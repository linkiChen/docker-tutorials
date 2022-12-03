FROM openjdk:11-jre
ENV APP_HOME=/apps
WORKDIR $APP_HOME
COPY ./api-service*.jar ./api.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar"]
CMD ["api.jar"]