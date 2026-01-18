package nl.hakktastic.pagination_demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "dummy_entity")
public class DummyJpaEntity {

  @Id
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String dummy_column1;
  private String dummy_column2;
  private String dummy_column3;
  private String dummy_column4;
  private String dummy_column5;
}