package com.ecom.product_api.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.*;

import java.sql.Blob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class FileResource {
    @Lob
    private Blob hash;
    @Lob
    private Blob fileName;
    @Lob
    private Blob resourceUrl;
    @Lob
    private Blob directory;
}
