package elearning.demo.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private static final String ENV_JDBC_PASSWORD = "jdbc.password";
    private static final String ENV_JDBC_USERNAME = "jdbc.username";
    private static final String ENV_JDBC_URL = "jdbc.url";

    @Autowired
    private Environment env;

    @Bean
    public DataSource DataSource() {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl(env.getProperty(ENV_JDBC_URL));
        bds.setUsername(env.getProperty(ENV_JDBC_USERNAME));
        bds.setPassword(env.getProperty(ENV_JDBC_PASSWORD));
        return bds;
    }

}
