package nl.hakktastic.pagination_demo;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoDummyService {

  private final DummyJpaEntityRepository dummyJpaEntityRepository;

  public Page<DummyJpaEntity> getAllEntitiesPageBased(final int page, final int size) {
    val pageable = PageRequest.of(page, size, Sort.by("id").ascending());
    return dummyJpaEntityRepository.findAll(pageable);
  }

  public Page<DummyJpaEntity> getAllEntitiesOffsetBased(final int offset, final int limit) {
    val pageable = OffsetBasedPageRequest.of(offset, limit);
    return dummyJpaEntityRepository.findAll(pageable);
  }
}