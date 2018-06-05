package springinaction.ch04;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"springinaction"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {
    @Bean
    public DataSource dataSource() throws IOException {
        BasicDataSource dataSource = new BasicDataSource();
        InputStream in = getClass().getResourceAsStream("/myspring.properties");
        Properties prop = new Properties();
        prop.load(in);
        dataSource.setDriverClassName(prop.getProperty("dataSource.driverClassName"));
        dataSource.setUrl(prop.getProperty("dataSource.url"));
        dataSource.setUsername(prop.getProperty("dataSource.username"));
        dataSource.setPassword(prop.getProperty("dataSource.password"));
        return dataSource;
    }

    @Bean
    public JdbcOperations jdbcOperations(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
