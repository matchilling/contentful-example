package com.matchilling.contentful.entity;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class EntityController {

  private final EntityService entityService;

  @QueryMapping("entityById")
  public Entity entityById(@Argument String id) {
    return entityService.getById(id);
  }

  @QueryMapping("entityByName")
  public List<Entity> entityByName(@Argument String name) {
    return entityService.findByName(name);
  }
}
