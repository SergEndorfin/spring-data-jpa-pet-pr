package com.itkon.jpaintro.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("clean")
@Configuration
public class DbClean {

    @Bean
    public FlywayMigrationStrategy cleanDb() {
        return flyway -> {
            flyway.clean();
            flyway.migrate();
        };
    }
}
