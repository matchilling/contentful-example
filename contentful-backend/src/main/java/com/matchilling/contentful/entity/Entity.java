package com.matchilling.contentful.entity;

import lombok.Builder;

@Builder
public record Entity(
    String id,
    String name,
    String type
) {

}
