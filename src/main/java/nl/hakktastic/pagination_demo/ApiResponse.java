package nl.hakktastic.pagination_demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDateTime;

@JsonInclude(Include.NON_EMPTY)
@JsonPropertyOrder({"status", "timestamp", "path", "data", "metadata"})
public record ApiResponse<T>(
    String status,
    LocalDateTime timestamp,
    String path,
    String message,
    T data,
    ApiResponseMetadata metadata) {

}