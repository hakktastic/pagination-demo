package nl.hakktastic.pagination_demo;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OffsetBasedPageRequest implements Pageable {

  private static final int MIN_VALUE_OFFSET = 0;
  private static final int MIN_VALUE_LIMIT = 1;
  private static final Sort SORT = Sort.by("id").ascending();

  private final long offset;
  private final int limit;

  public static OffsetBasedPageRequest of(long offset, int limit) {
    offsetShouldBePositive(offset);
    limitShouldBeGreaterThanZero(limit);

    return new OffsetBasedPageRequest(offset, limit);
  }

  @Override
  public int getPageSize() {
    return limit;
  }

  @Override
  public long getOffset() {
    return offset;
  }

  @Override
  public Sort getSort() {
    return SORT;
  }

  @Override
  public Pageable next() {
    val newOffset = Math.addExact(offset, limit);
    return new OffsetBasedPageRequest(newOffset, limit);
  }

  @Override
  public Pageable previousOrFirst() {
    val newOffset = Long.valueOf(Math.max(Math.min(offset, limit), MIN_VALUE_OFFSET));
    return new OffsetBasedPageRequest(newOffset, limit);
  }

  @Override
  public Pageable first() {
    return new OffsetBasedPageRequest(MIN_VALUE_OFFSET, limit);
  }

  @Override
  public Pageable withPage(int pageNumber) {
    val newOffset = Math.multiplyExact(pageNumber, limit);
    return new OffsetBasedPageRequest(newOffset, limit);
  }

  @Override
  public boolean hasPrevious() {
    return offset > MIN_VALUE_OFFSET;
  }

  @Override
  public int getPageNumber() {
    return Math.toIntExact(Math.divideExact(offset, limit));
  }

  private static void limitShouldBeGreaterThanZero(int limit) {
    if (limit < MIN_VALUE_LIMIT) {
      throw new IllegalArgumentException("Limit should be be greater than zero");
    }
  }

  private static void offsetShouldBePositive(long offset) {
    if (offset < MIN_VALUE_OFFSET) {
      throw new IllegalArgumentException("Offset should be positive");
    }
  }
}