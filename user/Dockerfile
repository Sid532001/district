FROM eclipse-temurin:21
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
ARG app_version
# expect the jar file in the target folder under with filename app.jar
COPY ./target/user-0.0.1-SNAPSHOT.jar ./app.jar

USER 1002
ENTRYPOINT ["java", "-jar", "/usr/app/app.jar"]
