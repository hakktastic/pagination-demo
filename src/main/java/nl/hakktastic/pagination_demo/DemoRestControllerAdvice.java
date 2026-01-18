package nl.hakktastic.pagination_demo;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DemoRestControllerAdvice {

  @ExceptionHandler(DummyEntityNotFoundException.class)
  ApiResponse<String> handleException(DummyEntityNotFoundException dummyEntityNotFoundException, HttpServletRequest httpServletRequest) {

    return new ApiResponse<>(
        HttpStatus.NOT_FOUND.toString(),
        LocalDateTime.now(),
        httpServletRequest.getRequestURI(),
        dummyEntityNotFoundException.getMessage(),
        Strings.EMPTY);
  }
}