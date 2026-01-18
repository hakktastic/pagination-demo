package nl.hakktastic.pagination_demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LargeJpaEntityRepository extends JpaRepository<LargeJpaEntity, Long> {

}