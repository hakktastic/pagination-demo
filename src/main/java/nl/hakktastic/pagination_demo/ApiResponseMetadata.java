package nl.hakktastic.pagination_demo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiResponseMetadata {

  private final int pageNumber;
  private final int pageSize;
  private final int totalPages;
  private final long totalElements;

  public static ApiResponseMetadata from(Page<DummyJpaEntity> page) {
    return new ApiResponseMetadata(
        page.getNumber(),
        page.getSize(),
        page.getTotalPages(),
        page.getTotalElements());
  }
}