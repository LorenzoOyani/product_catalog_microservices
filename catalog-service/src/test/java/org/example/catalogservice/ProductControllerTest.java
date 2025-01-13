package org.example.catalogservice;


import org.example.catalogservice.domain.PagedRequest;
import org.example.catalogservice.domain.ProductEntity;
import org.example.catalogservice.domain.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestConfiguration.class)
public class ProductControllerTest {
//    @Container
//    @ServiceConnection
//    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:14");

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void setup() {
        productRepository.deleteAllInBatch();
    }

    @Test
    void shouldGetAllProducts() {
        productRepository.save(new ProductEntity("P001", "A great product", "Product 1", "http://image1.jpg", new BigDecimal("10.99")));
        productRepository.save(new ProductEntity("P002", "A great product", "Product 2", "http://image2.jpg", new BigDecimal("10.98")));

        ParameterizedTypeReference<PagedRequest<ProductEntity>> responseType =
                new ParameterizedTypeReference<PagedRequest<ProductEntity>>() {
                };

        ResponseEntity<PagedRequest<ProductEntity>> responseEntity=
                restTemplate.exchange("/api/products/findProduct?page=0", HttpMethod.GET,
                        null, responseType
                        );

        PagedRequest<ProductEntity> response = responseEntity.getBody();

        assertNotNull(response);
        assertNotNull(response.content());
        assertEquals(2, response.content().size());
        assertEquals("P001", response.content().get(0).getCode());
        assertEquals("P002", response.content().get(1).getCode());
    }

}
