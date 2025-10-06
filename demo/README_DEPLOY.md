Render deployment steps (Spring Boot + Postgres)

1) Push your repo to GitHub (Render will pull from GitHub). Example PowerShell commands:

   git init
   git add .
   git commit -m "Initial commit"
   git branch -M main
   git remote add origin https://github.com/<your-username>/<your-repo>.git
   git push -u origin main

2) Create a new Web Service on Render
   - Connect your GitHub account and pick the repo.
   - Build Command: `demo\\mvnw.cmd -f demo\\pom.xml -DskipTests package` (Windows) or `cd demo && ./mvnw -DskipTests package` (Unix)
   - Start Command: `java -Dserver.port=$PORT -Dspring.profiles.active=prod -jar demo/target/demo-0.0.1-SNAPSHOT.jar`

3) Add Postgres on Render
   - In Render dashboard, create a new "Postgres" database.
   - Note the connection URL, user, and password. They will look like: postgres://user:pass@internal-db-host:5432/dbname

4) Set Environment Variables for the Web Service
   - SPRING_DATASOURCE_URL (use the JDBC URL form: jdbc:postgresql://host:5432/dbname)
   - SPRING_DATASOURCE_USERNAME
   - SPRING_DATASOURCE_PASSWORD
   - PORT (Render sets this automatically; you don't need to set it manually)

   Example values (do NOT commit these):
   SPRING_DATASOURCE_URL=jdbc:postgresql://private-host.internal:5432/yourdb
   SPRING_DATASOURCE_USERNAME=youruser
   SPRING_DATASOURCE_PASSWORD=yourpassword

5) Start the service. Render will build and start it. Check the service logs for "Tomcat started on port" and Hikari connection messages.

Notes
   - I added `src/main/resources/application-prod.properties` which uses environment variables if present. The app will pick up these values when you run with profile `prod` or when Render injects env vars.
   - Recommended: set `SPRING_PROFILES_ACTIVE=prod` in the Render service environment variables so Spring loads `application-prod.properties`.
   - Use migration tool (Flyway/Liquibase) for production schema changes instead of `ddl-auto=update`.

If you want, I can:
   - Create a `.github/workflows` GitHub Action for auto-deploy to Render (optional).
   - Add a `.env.example` and update `application.properties` with clearer comments.
