//package org.example.catalogservice.configuration;
//
//import org.flywaydb.core.Flyway;
//import org.flywaydb.core.api.configuration.FluentConfiguration;
//import org.flywaydb.core.internal.database.postgresql.PostgreSQLDatabaseType;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FlywayConfig {
//
//    @Bean(initMethod = "migrate")
//    public Flyway flyway() {
//        FluentConfiguration configuration = Flyway.configure()
//                .dataSource("jdbc:postgresql://localhost:5432/your_database", "username", "password")
//                .baselineOnMigrate(true);
//
//        // Bypass version check for PostgreSQL 16.x
//// No need to manually call 'createDataSource', replace the logic to directly configure the database type using Flyway's configuration API
//
//        configuration.getPluginRegister()
//                .addPlugin(new PostgreSQLDatabaseType() {
//                    @Override
//                    public boolean handlesJDBCUrl(String url) {
//                        return super.handlesJDBCUrl(url);
//                    }
//
//                    @Override
//                    public String toString() {
//                        return "PostgreSQL workaround for 16.x";
//                    }
//                });
//
//        return new Flyway(configuration);
//    }
//}