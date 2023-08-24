package az.atlacademy.springjpaexample.mapper;

import az.atlacademy.springjpaexample.dao.entity.ProductEntity;
import az.atlacademy.springjpaexample.model.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDto, ProductEntity> {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

}
