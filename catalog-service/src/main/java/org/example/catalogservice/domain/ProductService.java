package org.example.catalogservice.domain;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

    final ProductRepository productRepository;
    final ApplicationProperties properties;

    final ProductMappers productMapper;

    public ProductService(ProductRepository productRepository, ApplicationProperties properties, ProductMappers productMapper) {
        this.productRepository = productRepository;
        this.properties = properties;
        this.productMapper = productMapper;
    }

    public PagedRequest<Product> findAllProducts(int pageNo) {
        Sort sort = Sort.by("name").descending();

        pageNo = pageNo <= 1 ? 0 : pageNo - 1;

        Pageable pageable = PageRequest.of(pageNo, properties.pageSize(), sort);

        Page<ProductEntity> productList = productRepository.findAll(pageable);
        System.out.println("Products from Database: "+ productList.getContent());

        Page<Product> productLists = productRepository.findAll(pageable)
                .map(product -> {
                    Product mapped = productMapper.toModel(product);
                    System.out.println("Mapped Product: " + mapped);
                    return mapped;
                });
        System.out.println("Mapped Products: " + productLists.getContent());
        System.out.println("Total Pages: " + productLists.getTotalPages());
        System.out.println("Total Elements: " + productLists.getTotalElements());
        System.out.println("Page Number: " + productLists.getNumber());
        System.out.println("Is First Page: " + productLists.isFirst());
        System.out.println("Is Last Page: " + productLists.isLast());
        System.out.println("Has Previous Page: " + productLists.hasPrevious());
        System.out.println("Has Next Page: " + productLists.hasNext());
        System.out.println("Size: " + productLists.getSize());


        PagedRequest<Product> pagedRequest = new PagedRequest<>(
                productLists.getContent(),
                productList.getTotalElements(),
                productLists.getNumber() + 1,
                productLists.getTotalPages(),
                productLists.isFirst(),
                productLists.hasNext(),
                productLists.hasPrevious(),
                productLists.isLast()
        );
        System.out.println("PagedRequest: " + pagedRequest);


        return pagedRequest;

    }
}
