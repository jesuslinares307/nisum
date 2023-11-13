package com.latam.nisum.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

/*@Slf4j
@Configuration
@EnableJpaRepositories(basePackages = "com.latam.nisum.repository")
public class NisumDatabaseConfig {

    private final String host;
    private final String username;
    private final String password;
    private final String schema;


    public NisumDatabaseConfig(@Value("${mysql.nisum.connection.host}") String host,
                               @Value("${mysql.nisum.connection.username}") String username,
                               @Value("${mysql.nisum.connection.password}") String password,
                               @Value("${mysql.nisum.connection.schema}") String schema
    ) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.schema = schema;

    }

    @Bean
    public DataSource dataSource() {
        HikariConfig config  = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://" + host + "/" + schema);
        config.setUsername(username);
        config.setPassword(password);
        return new HikariDataSource(config);
    }

}*/
