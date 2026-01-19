package nl.hakktastic.pagination_demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

@Data
@JsonInclude(Include.NON_EMPTY)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@JsonPropertyOrder({"status", "timestamp", "clientIp", "path", "data", "metadata"})
public final class ApiResponse {

  private final String status;
  private final LocalDateTime timestamp;
  private final String path;
  private final String clientIp;
  private final List<ApiResponseDataElement> data;
  private final ApiResponseMetadata metadata;

  public static ApiResponse of(HttpStatus status, HttpServletRequest httpServletRequest, Page<DummyJpaEntity> dummyJpaEntitiesPage) {
    return new ApiResponse(
        status.toString(),
        LocalDateTime.now(),
        httpServletRequest.getRequestURI(),
        httpServletRequest.getRemoteAddr(),
        dummyJpaEntitiesPage.getContent()
            .stream()
            .map(ApiResponseDataElement::from)
            .toList(),
        ApiResponseMetadata.from(dummyJpaEntitiesPage)
    );
  }
}