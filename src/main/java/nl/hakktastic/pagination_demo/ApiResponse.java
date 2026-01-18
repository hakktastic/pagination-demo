package nl.hakktastic.ratelimiter;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class ApiResponse<T> {

  private final String Status;
  private final LocalDateTime timestamp;
  private final String message;
  private final T data;
}