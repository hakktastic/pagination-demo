package nl.hakktastic.pagination_demo;

import jakarta.servlet.http.HttpServletRequest;
import java.net.URI;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @see <a href='https://datatracker.ietf.org/doc/html/rfc7807'>RFC7807</a>
 */
@RestControllerAdvice
public class DemoRestControllerAdvice {

  private static final URI URI_PROBLEM_TYPE_ENTITY_BAD_REQUEST = URI.create("https://dummy.example.com/problems/bad-request");

  @ExceptionHandler(IllegalArgumentException.class)
  ProblemDetail handleBadRequest(IllegalArgumentException illegalArgumentException, HttpServletRequest httpServletRequest) {

    val problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problem.setType(URI_PROBLEM_TYPE_ENTITY_BAD_REQUEST);
    problem.setTitle("Illegal Argument");
    problem.setDetail(illegalArgumentException.getMessage());
    problem.setInstance(URI.create(httpServletRequest.getRequestURI()));

    return problem;
  }
}