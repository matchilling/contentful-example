package com.matchilling.contentful.entity;

import com.matchilling.contentful.exception.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class EntityRepository {

  private static final List<Entity> EXAMPLES = List.of(
      Entity.builder().id("461ccba0-fd5e-4f89-923f-c75b7d14cb71").name("John Doe").type("person").build(),
      Entity.builder().id("3c395159-11b6-4528-9968-986e995a1d07").name("Jane Doe").type("person").build()
  );

  public Entity getById(String id) {
    return EXAMPLES.stream()
        .filter(it -> it.id().compareToIgnoreCase(id) == 0)
        .findFirst()
        .orElseThrow(() -> new EntityNotFoundException(
            Entity.class,
            id
        ));
  }

  public List<Entity> findByName(
      String name
  ) {
    return EXAMPLES.stream()
        .filter(it -> it.name().compareToIgnoreCase(name) == 0)
        .collect(Collectors.toList());
  }

}
