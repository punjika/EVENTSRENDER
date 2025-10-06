# EVENTSRENDER — Backend

This repository contains a Spring Boot backend (module `demo`) for the Events project.

## Quick overview
- Java: 17
- Build: Maven
- App module: `demo`

## Local build (Windows PowerShell)
1. Build using the Maven wrapper inside `demo`:

```powershell
cd demo
.\mvnw.cmd -DskipTests package
```

2. Verify the jar was created:

```powershell
Get-ChildItem .\target\demo-0.0.1-SNAPSHOT.jar
```

3. Run locally (example using JDBC env vars for a remote Postgres):

```powershell
java -Dserver.port=8080 -jar demo\target\demo-0.0.1-SNAPSHOT.jar
```

## Deploying to Render (no Docker)
If you want to deploy without Docker, let Render build from the repository and provide a Start Command.

Build command (set on Render):

```
demo\\mvnw.cmd -f demo\\pom.xml -DskipTests package
```

Start command:

```
java -Dserver.port=$PORT -Dspring.profiles.active=prod -jar demo/target/demo-0.0.1-SNAPSHOT.jar
```

## Deploying to Railway (no Docker)
If Railway is building from your repo, set the Build Command to:

```
demo\\mvnw.cmd -f demo\\pom.xml -DskipTests package
```

Start command:

```
java -Dserver.port=$PORT -Dspring.profiles.active=prod -jar demo/target/demo-0.0.1-SNAPSHOT.jar
```

## Database schema
- For production use, add proper migrations (Flyway/Liquibase). A temporary option is to set `SPRING_JPA_HIBERNATE_DDL_AUTO=update` to let Hibernate create missing tables on startup (not recommended long-term).

## Troubleshooting
- If you see `Unable to access jarfile`, verify the jar exists under `demo/target` and the Dockerfile is pointing to the correct path.
- Platform build logs (Railway/Render) often show the exact failing command — paste logs here if you want me to help dig in.

---
If you'd like I can also:
- Add Flyway migrations (generate `V1__init.sql`) and commit them under `demo/src/main/resources/db/migration`.
- Add a release workflow that tags Docker images.

Tell me which of those you'd like next and I'll implement it.
