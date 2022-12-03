FROM openjdk:11-jre
ENV APP_HOME=/apps
WORKDIR $APP_HOME
COPY ./docker-demo-gateway*.jar ./gateway.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar"]
CMD ["gateway.jar"]