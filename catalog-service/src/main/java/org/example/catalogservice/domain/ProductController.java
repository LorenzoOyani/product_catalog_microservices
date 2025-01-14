package org.example.catalogservice.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/findProduct")
  public PagedRequest<Product> findAllProducts(
      @RequestParam(name = "page", defaultValue = "1") int pageNo) {
    return productService.findAllProducts(pageNo);
  }
}
