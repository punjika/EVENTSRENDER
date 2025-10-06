#!/bin/sh
set -e

JAR_CANDIDATES="/app/app.jar target/demo-0.0.1-SNAPSHOT.jar /workspace/target/demo-0.0.1-SNAPSHOT.jar"

echo "Looking for application jar in:"
for j in $JAR_CANDIDATES; do
  echo " - $j"
done

found=
for j in $JAR_CANDIDATES; do
  if [ -f "$j" ]; then
    found=$j
    break
  fi
done

if [ -z "$found" ]; then
  echo "ERROR: no jar found. Directory listing of /app and /workspace and /workspace/target follows:"
  echo "--- /app ---"
  ls -la /app || true
  echo "--- /workspace ---"
  ls -la /workspace || true
  echo "--- /workspace/target ---"
  ls -la /workspace/target || true
  echo "Container cannot start without the built jar. Did the build succeed?"
  exit 1
fi

echo "Starting with jar: $found"
exec sh -c "java $JAVA_OPTS -Dserver.port=${PORT:-8080} -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE:-prod} -jar $found"
