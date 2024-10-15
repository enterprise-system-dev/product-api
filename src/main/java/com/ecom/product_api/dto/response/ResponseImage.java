package com.ecom.product_api.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseImage {
    private String id;
    private String resourceUrl;
}
