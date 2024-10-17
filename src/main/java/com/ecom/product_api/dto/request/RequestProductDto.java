package com.ecom.product_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestProductDto {

    @NotBlank(message = "description is mandatory")
    @Size(min = 10, max = 1000, message = "description char list must between 10-1000")
    private String description;
    @NotBlank(message = "unit price is mandatory")
    private double unitPrice;
    @NotBlank(message = "qty is mandatory")
    private int qty;

}
