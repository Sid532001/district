FROM eclipse-temurin:21
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
ARG app_version
# expect the jar file in the target folder under with filename app.jar
COPY ./target/admin-${app_version}.jar ./app.jar
ENTRYPOINT ["sh","/usr/app/service_entrypoint.sh"]

