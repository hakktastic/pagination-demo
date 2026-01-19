package nl.hakktastic.pagination_demo;

import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiResponseData {

  private final List<ApiResponseDataElement> apiResponseDataElements;

  public static ApiResponseData from(Page<DummyJpaEntity> page) {
    val responseDataElements = page.getContent()
        .stream()
        .map(ApiResponseDataElement::from)
        .toList();

    return new ApiResponseData(responseDataElements);
  }
}