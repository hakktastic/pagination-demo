package nl.hakktastic.pagination_demo;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoRestService {

  private final DummyJpaEntityRepository dummyJpaEntityRepository;

  public List<DummyJpaEntity> getAllEntities() {
    return dummyJpaEntityRepository.findAll();
  }
}