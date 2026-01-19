package nl.hakktastic.pagination_demo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiResponseDataElement {

  private final String dummy_column1;
  private final String dummy_column2;
  private final String dummy_column3;
  private final String dummy_column4;
  private final String dummy_column5;

  public static ApiResponseDataElement from(DummyJpaEntity dummyJpaEntity) {
    return new ApiResponseDataElement(dummyJpaEntity.getDummy_column1(),
        dummyJpaEntity.getDummy_column2(),
        dummyJpaEntity.getDummy_column3(),
        dummyJpaEntity.getDummy_column4(),
        dummyJpaEntity.getDummy_column5()
    );
  }
}