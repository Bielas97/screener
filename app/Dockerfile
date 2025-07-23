FROM azul/zulu-openjdk:21.0.8-21.44
ARG SERVICE
EXPOSE 8080:8080
RUN mkdir /app
COPY $SERVICE/build/libs/*.jar /app/application.jar
ENTRYPOINT ["java","-jar","/app/application.jar"]
