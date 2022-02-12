package nl.lyashevska.conferenceapp.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:mysql://213.136.26.35:3306/olgatest1");
        System.out.println("My custom datasource bean has been initialised and set");
        return builder.build();
    }
}
