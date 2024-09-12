secrets=$(ls /admin-secrets)
for f in $secrets; do
  export "$f"=$(cat /admin-secrets/${f})
done

exec java $JAVA_OPTS -jar ${APP_HOME}/app.jar