package nl.hakktastic.pagination_demo;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/dummy-entities")
public class DemoRestController {

  private final DemoDummyService demoDummyService;

  @GetMapping("/page-based")
  public ResponseEntity<ApiResponse<Page<DummyJpaEntity>>> getDummyEntitiesPageBased(@RequestParam(defaultValue = "0", required = false) final int page,
      @RequestParam(defaultValue = "10", required = false) final int size,
      final HttpServletRequest httpServletRequest) {

    val dummyEntities = demoDummyService.getAllEntitiesPageBased(page, size);
    val apiResponse = new ApiResponse<>(
        HttpStatus.OK.toString(),
        LocalDateTime.now(),
        httpServletRequest.getRequestURI(),
        Strings.EMPTY,
        dummyEntities);

    return ResponseEntity.ok(apiResponse);
  }

  @GetMapping("/offset-based")
  public ResponseEntity<ApiResponse<Page<DummyJpaEntity>>> getDummyEntitiesOffsetBased(@RequestParam(defaultValue = "0") final int offset,
      @RequestParam(defaultValue = "1") final int limit,
      final HttpServletRequest httpServletRequest) {

    val dummyEntities = demoDummyService.getAllEntitiesOffsetBased(offset, limit);
    val apiResponse = new ApiResponse<>(
        HttpStatus.OK.toString(),
        LocalDateTime.now(),
        httpServletRequest.getRequestURI(),
        Strings.EMPTY,
        dummyEntities);

    return ResponseEntity.ok(apiResponse);
  }
}