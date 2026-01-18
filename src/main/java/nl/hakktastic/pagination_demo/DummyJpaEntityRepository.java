package nl.hakktastic.pagination_demo;

import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface DummyJpaEntityRepository extends ListPagingAndSortingRepository<DummyJpaEntity, Long> {

}