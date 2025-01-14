package org.example.catalogservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import org.example.catalogservice.domain.ProductEntity;
import org.example.catalogservice.domain.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

@DataJpaTest
@Import(TestConfiguration.class)
public class ProductRepositoryTest {

  @Container @ServiceConnection
  static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:14");

  @Autowired private ProductRepository productRepository;

  @BeforeEach
  void setup() {
    productRepository.deleteAllInBatch();
  }

  @Test
  public void shouldSaveProductInRepository() {
    productRepository.save(
        new ProductEntity(
            "P001", "A great product", "Product 1", "http://image1.jpg", new BigDecimal("10.99")));
    productRepository.save(
        new ProductEntity(
            "P002", "A great product", "Product 2", "http://image2.jpg", new BigDecimal("10.98")));

    List<ProductEntity> productEntityList = productRepository.findAll();

    assertThat(productEntityList).hasSize(2);
    assertThat(productEntityList.get(0).getCode()).isEqualTo("P001");
    assertThat(productEntityList.get(1).getCode()).isEqualTo("P002");
  }
}
