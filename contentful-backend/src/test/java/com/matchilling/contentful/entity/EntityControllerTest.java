package com.matchilling.contentful.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@AutoConfigureGraphQlTester
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class EntityControllerTest {

  @Autowired
  private GraphQlTester tester;

  @Nested
  class EntityByIdTest {

    @Test
    @DisplayName("Should find entity b y its primary id")
    void findById() {
      // given:
      var query = "{entityById(id: \"461ccba0-fd5e-4f89-923f-c75b7d14cb71\") {id name type}}";

      // when:
      var actual = tester.document(query)
          .execute()
          .path("data.entityById")
          .entity(Entity.class)
          .get();

      // then:
      Assertions.assertNotNull(actual);

      // and:
      Assertions.assertNotNull(actual.id());
      Assertions.assertNotNull(actual.name());
      Assertions.assertNotNull(actual.type());
    }
  }
}
