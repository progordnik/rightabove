package rightabove.test.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class DBConfigurator {

    @Bean
    public Connection getDataSource() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rightabove?currentSchema=animal", "postgres", "admin");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
