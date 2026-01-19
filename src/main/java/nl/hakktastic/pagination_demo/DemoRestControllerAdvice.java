package nl.hakktastic.pagination_demo;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import lombok.val;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DemoRestControllerAdvice {

  @ExceptionHandler(DummyEntityNotFoundException.class)
  ResponseEntity<ApiResponse<String>> handleNotFound(DummyEntityNotFoundException dummyEntityNotFoundException, HttpServletRequest httpServletRequest) {

    val apiResponse = new ApiResponse<>(
        HttpStatus.NOT_FOUND.toString(),
        LocalDateTime.now(),
        httpServletRequest.getRequestURI(),
        dummyEntityNotFoundException.getMessage(),
        Strings.EMPTY);

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);

  }

  @ExceptionHandler(IllegalArgumentException.class)
  ResponseEntity<ApiResponse<String>> handleBadRequest(IllegalArgumentException illegalArgumentException, HttpServletRequest httpServletRequest) {

    val apiResponse = new ApiResponse<>(
        HttpStatus.BAD_REQUEST.toString(),
        LocalDateTime.now(),
        httpServletRequest.getRequestURI(),
        illegalArgumentException.getMessage(),
        Strings.EMPTY);

    return ResponseEntity.badRequest().body(apiResponse);
  }
}