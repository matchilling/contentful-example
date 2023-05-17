package com.matchilling.contentful.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {

  private Class clazz;
  private String identifier;

  public EntityNotFoundException(Class clazz, String identifier) {
    super(
        String.format("Type %s with id %s not found", clazz.getName(), identifier)
    );

    this.clazz = clazz;
    this.identifier = identifier;
  }
}