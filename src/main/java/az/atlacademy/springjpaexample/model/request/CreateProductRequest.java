package az.atlacademy.springjpaexample.model.request;

import az.atlacademy.springjpaexample.model.enums.ProductEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

    @NotBlank
    private String name;

    @Min(0)
    private BigDecimal price;

    @NotNull
    private ProductEnum category;

}
