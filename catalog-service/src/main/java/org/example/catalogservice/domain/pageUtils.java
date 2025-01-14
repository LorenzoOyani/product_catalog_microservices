package org.example.catalogservice.domain;

import org.springframework.data.domain.PageRequest;

public final class pageUtils {

  private final PageRequest DEFAULT_PAGE = PageRequest.of(0, 10);

  private PageRequest createRequest(Integer page, Integer pageSize) {
    if (page == null || page < 0) {
      page = 0;
    }

    if (pageSize == null || pageSize < 0) {
      pageSize = 10;
    }

    return PageRequest.of(page, pageSize);
  }
}
