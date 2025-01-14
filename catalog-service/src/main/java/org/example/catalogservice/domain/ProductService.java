package org.example.catalogservice.domain;

import jakarta.transaction.Transactional;
import java.util.List;
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

  public ProductService(
      ProductRepository productRepository,
      ApplicationProperties properties,
      ProductMappers productMapper) {
    this.productRepository = productRepository;
    this.properties = properties;
    this.productMapper = productMapper;
  }

  public PagedRequest<Product> findAllProducts(int pageNo) {
    Sort sort = Sort.by("name").ascending();

    pageNo = pageNo <= 1 ? 0 : pageNo - 1;

    Pageable pageable = PageRequest.of(pageNo, properties.pageSize(), sort);

    Page<ProductEntity> productList = productRepository.findAll(pageable);
    System.out.println("Products from Database: " + productList.getContent());

    //        Set<String> immutableProducts = new HashSet<>();
    List<Product> distinctProducts =
        productList.stream()
            .map(productMapper::toModel)
            //                .filter(product -> immutableProducts.add(product.getCode())) // Add to
            // set and filter duplicates
            .toList();

    PagedRequest<Product> pagedRequest =
        new PagedRequest<>(
            distinctProducts,
            productList.getTotalElements(),
            productList.getNumber() + 1,
            productList.getTotalPages(),
            productList.isFirst(),
            productList.hasNext(),
            productList.hasPrevious(),
            productList.isLast());
    System.out.println("PagedRequest: " + pagedRequest);

    return pagedRequest;
  }
}
