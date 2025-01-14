// package org.example.catalogservice;
//
// import org.springframework.boot.test.context.TestConfiguration;
// import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
// import org.springframework.context.annotation.Bean;
// import org.springframework.test.context.DynamicPropertyRegistry;
// import org.springframework.test.context.DynamicPropertySource;
// import org.testcontainers.containers.PostgreSQLContainer;
// import org.testcontainers.utility.DockerImageName;
//
//
//
//
// @TestConfiguration(proxyBeanMethods = false)
// public class TestContainerConfig {
//
//    @ServiceConnection
//    private static final PostgreSQLContainer<?> POSTGRES_CONTAINER;
//
//    static {
//        POSTGRES_CONTAINER = new PostgreSQLContainer<>(DockerImageName.parse("postgres:14"))
//                .withDatabaseName("postgres")
//                .withUsername("postgres")
//                .withPassword("Admin");
//        POSTGRES_CONTAINER.start();
//    }
//
//    @Bean
//    public PostgreSQLContainer<?> postgresContainer() {
//        return POSTGRES_CONTAINER;
//    }
//
//    @DynamicPropertySource
//    public static void configureProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", POSTGRES_CONTAINER::getJdbcUrl);
//        registry.add("spring.datasource.username", POSTGRES_CONTAINER::getUsername);
//        registry.add("spring.datasource.password", POSTGRES_CONTAINER::getPassword);
//    }
// }
