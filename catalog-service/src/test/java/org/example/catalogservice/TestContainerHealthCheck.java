// package org.example.catalogservice;
//
// import static org.assertj.core.api.Assertions.assertThat;
//
//  import org.junit.jupiter.api.Test;
//  import org.springframework.beans.factory.annotation.Autowired;
//  import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.context.annotation.Import;
// import org.testcontainers.containers.PostgreSQLContainer;
//
//  @SpringBootTest
//  @Import(TestContainerConfig.class)
//  public class TestContainerHealthCheck {
//
//      @Autowired
//      private PostgreSQLContainer<?> postgresContainer;
//
//      @Test
//      void testPostgreSQLConnection() {
//          assertThat(postgresContainer.isRunning()).isTrue();
//          assertThat(postgresContainer.getJdbcUrl()).isNotEmpty();
//      }
//  }
