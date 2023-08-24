package az.atlacademy.springjpaexample.model.dto;

import az.atlacademy.springjpaexample.model.enums.ProductEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private long id;
    private String name;
    private BigDecimal price;
    private ProductEnum category;

}
