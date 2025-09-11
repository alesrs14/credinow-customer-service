FROM eclipse-temurin:21-jdk-alpine
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

VOLUME /tmp
COPY ../applications/app-service/build/libs/CrediNow.jar CrediNow.jar
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
# Replace with a non-root user to avoid running the container with excessive privileges
USER appuser
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar CrediNow.jar" ]
