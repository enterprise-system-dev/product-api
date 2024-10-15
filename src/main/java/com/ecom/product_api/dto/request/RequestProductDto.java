package com.ecom.product_api.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestProductDto {

    private String description;
    private double unitPrice;
    private int qty;

}
