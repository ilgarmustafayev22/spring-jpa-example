package az.atlacademy.springjpaexample.mapper;

import az.atlacademy.springjpaexample.dao.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface EntityMapper<D, E> {

    E toEntity(D dto);

    List<E> toEntity(List<D> dtoList);

    D toDto(E entity);

    List<D> toDto(List<E> entityList);


    D toDto(Optional<E> byId);
}
