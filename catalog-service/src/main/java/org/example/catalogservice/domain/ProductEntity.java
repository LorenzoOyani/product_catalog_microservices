package org.example.catalogservice.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_generator")
    @SequenceGenerator(name = "product_id_generator", sequenceName = "product_id_sequence")
    private Long id;

    @JsonProperty(value = "code")
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "code must not be empty")
    private String code;

    @JsonProperty
    @NotNull(message = "cannot be null")
    private String description;

    @JsonProperty
    @NotNull(message = "product name is required")
    private String name;

    private String imageUrl;

    @JsonProperty
    @DecimalMin(value = "0.1")
    @Column(nullable = false)
    private BigDecimal price;

    // Additional Constructor (excluding id)
    public ProductEntity(String code, String description, String name, String imageUrl, BigDecimal price) {
        this.code = code;
        this.description = description;
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public ProductEntity() {

    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}