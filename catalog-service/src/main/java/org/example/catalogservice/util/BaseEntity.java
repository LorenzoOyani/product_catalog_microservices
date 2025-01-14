package org.example.catalogservice.util;

import jakarta.validation.constraints.NotNull;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseEntity<T, U> {

  public abstract U toEntity(T entity, Object... args);

  public abstract T fromEntity(U entity, Object... args);

  public Collection<U> toEntities(@NotNull Collection<T> entities, Object... args) {
    return entities.stream().map(entity -> toEntity(entity, args)).collect(Collectors.toList());
  }

  public Collection<T> fromEntities(@NotNull Collection<U> entities, Object... args) {
    return entities.stream().map(entity -> fromEntity(entity, args)).collect(Collectors.toList());
  }
}
