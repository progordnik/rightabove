package rightabove.test.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DBConfigurator {

    @Bean
    public DataSource getDataSource() {
        return null;
    }
}
