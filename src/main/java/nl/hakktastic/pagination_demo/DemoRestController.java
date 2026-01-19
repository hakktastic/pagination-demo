package nl.hakktastic.pagination_demo;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.val;
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
  public ResponseEntity<ApiResponse> getDummyEntitiesPageBased(
      @RequestParam(defaultValue = "0", required = false) final int page,
      @RequestParam(defaultValue = "10", required = false) final int size,
      final HttpServletRequest httpServletRequest) {

    val dummyJpaEntitiesPage = demoDummyService.getAllEntitiesPageBased(page, size);
    val apiResponse = ApiResponse.of(
        HttpStatus.OK,
        httpServletRequest,
        dummyJpaEntitiesPage
    );

    return ResponseEntity.ok(apiResponse);
  }

  @GetMapping("/offset-based")
  public ResponseEntity<ApiResponse> getDummyEntitiesOffsetBased(
      @RequestParam(defaultValue = "0") final int offset,
      @RequestParam(defaultValue = "1") final int limit,
      final HttpServletRequest httpServletRequest) {

    val dummyJpaEntitiesPage = demoDummyService.getAllEntitiesOffsetBased(offset, limit);
    val apiResponse = ApiResponse.of(
        HttpStatus.OK,
        httpServletRequest,
        dummyJpaEntitiesPage
    );

    return ResponseEntity.ok(apiResponse);
  }
}