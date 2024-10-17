package com.ecom.product_api.service.impl;

import com.ecom.product_api.dto.CommonFileSavedBinaryDataDto;
import com.ecom.product_api.dto.request.RequestProductDto;
import com.ecom.product_api.dto.response.ResponseProductDto;
import com.ecom.product_api.dto.response.paginate.ResponseProductPaginate;
import com.ecom.product_api.entity.FileResource;
import com.ecom.product_api.entity.Images;
import com.ecom.product_api.entity.Product;
import com.ecom.product_api.repository.ProductRepo;
import com.ecom.product_api.service.FileService;
import com.ecom.product_api.service.ProductService;
import com.ecom.product_api.util.FileDataExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final FileService fileService;
    private final FileDataExtractor fileDataExtractor;
    private final ProductRepo productRepo;
    @Value("${bucketName}")
    private String bucketName;

    @Override
    public void createProduct(RequestProductDto dto, MultipartFile file) {
        CommonFileSavedBinaryDataDto resource =null;
        try{
            resource = fileService.create(file,"abc/images/srilanka/",bucketName);
            Set<Images> images = new HashSet<>();
            images.add(
                    Images.builder()
                            .fileResource(
                                   new FileResource(
                                           resource.getHash(), resource.getFileName(),
                                           resource.getResourceUrl(), resource.getDirectory()
                                   )
                            )
                            .id(UUID.randomUUID().toString())
                            .build()
            );
            Product product = Product.builder()
                    .qty(dto.getQty())
                    .description(dto.getDescription())
                    .images(images)
                    .productId(UUID.randomUUID().toString())
                    .unitPrice(dto.getUnitPrice())
                    .build();
            productRepo.save(product);
        } catch (SQLException | IOException e) {
                fileService.delete(fileDataExtractor.blobToString(resource.getDirectory()),
                        fileDataExtractor.blobToString(resource.getFileName()),bucketName);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProduct(RequestProductDto dto, String productId) {

    }

    @Override
    public void deleteProduct(String productId) {

    }

    @Override
    public ResponseProductDto findProductById(String productId) {
        return null;
    }

    @Override
    public ResponseProductPaginate searchAllProducts(String searchText, int page, int size) {
        return null;
    }

    @Override
    public void updateImage(String imageId, MultipartFile file) {

    }

    @Override
    public void deleteImage(String imageId) {

    }
}
