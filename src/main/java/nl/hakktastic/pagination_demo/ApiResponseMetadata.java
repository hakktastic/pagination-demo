package nl.hakktastic.pagination_demo;

import org.springframework.data.domain.Page;

public record ApiResponseMetadata(int pageNumber, int pageSize, int totalPages, long totalElements) {

  public static ApiResponseMetadata from(Page page) {
    return new ApiResponseMetadata(
        page.getNumber(),
        page.getSize(),
        page.getTotalPages(),
        page.getTotalElements());
  }
}