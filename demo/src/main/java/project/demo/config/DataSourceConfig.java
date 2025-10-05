package project.demo.config;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {

    private final Environment env;

    public DataSourceConfig(Environment env) {
        this.env = env;
    }

    @Value("${spring.datasource.url:}")
    private String propUrl;

    @Value("${spring.datasource.username:}")
    private String propUser;

    @Value("${spring.datasource.password:}")
    private String propPass;

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        // Priority: SPRING_DATASOURCE_URL -> DATABASE_URL (Render style) -> property spring.datasource.url
        String url = env.getProperty("SPRING_DATASOURCE_URL");
        String user = env.getProperty("SPRING_DATASOURCE_USERNAME");
        String pass = env.getProperty("SPRING_DATASOURCE_PASSWORD");

        if (isEmpty(url)) {
            // Render often provides DATABASE_URL in the form: postgresql://user:pass@host:port/db
            String databaseUrl = env.getProperty("DATABASE_URL");
            if (!isEmpty(databaseUrl)) {
                url = toJdbcUrl(databaseUrl);
                // try to extract creds if SPRING_DATASOURCE_USERNAME not set
                if (isEmpty(user) || isEmpty(pass)) {
                    try {
                        URI uri = new URI(databaseUrl);
                        String[] userInfo = uri.getUserInfo() != null ? uri.getUserInfo().split(":") : new String[0];
                        if (userInfo.length > 0 && isEmpty(user)) user = userInfo[0];
                        if (userInfo.length > 1 && isEmpty(pass)) pass = userInfo[1];
                    } catch (Exception e) {
                        // ignore and fallback
                    }
                }
            }
        }

        if (isEmpty(url)) {
            url = propUrl;
            user = isEmpty(user) ? propUser : user;
            pass = isEmpty(pass) ? propPass : pass;
        }

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl(url);
        if (!isEmpty(user)) ds.setUsername(user);
        if (!isEmpty(pass)) ds.setPassword(pass);
        return ds;
    }

    private boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    private String toJdbcUrl(String databaseUrl) throws URISyntaxException {
        // convert postgresql://user:pass@host:port/db to jdbc:postgresql://host:port/db
        if (databaseUrl.startsWith("jdbc:")) return databaseUrl;
        if (databaseUrl.startsWith("postgresql://") || databaseUrl.startsWith("postgres://")) {
            URI uri = new URI(databaseUrl);
            String host = uri.getHost();
            int port = uri.getPort() == -1 ? 5432 : uri.getPort();
            String path = uri.getPath();
            return String.format("jdbc:postgresql://%s:%d%s", host, port, path == null ? "" : path);
        }
        // fallback: return as-is
        return databaseUrl;
    }
}
