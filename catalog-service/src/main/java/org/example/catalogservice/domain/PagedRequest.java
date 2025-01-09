package org.example.catalogservice.domain;

import java.util.List;

public record PagedRequest<T>(
        List<T> content,
        long totalElement,
        int pageNumber,
        int totalPages,
        boolean isFirst,
        boolean hasNext,
        boolean hasPrevious,
        boolean isLast
) {
}
