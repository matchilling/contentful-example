package com.matchilling.contentful.entity;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntityService {

  private final EntityRepository entityRepository;

  public Entity getById(String id) {
    return entityRepository.getById(id);
  }

  public List<Entity> findByName(String name) {
    return entityRepository.findByName(name);
  }
}
