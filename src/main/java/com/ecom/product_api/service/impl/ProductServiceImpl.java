package com.ecom.product_api.service.impl;

import com.ecom.product_api.dto.request.RequestProductDto;
import com.ecom.product_api.dto.response.ResponseProductDto;
import com.ecom.product_api.dto.response.paginate.ResponseProductPaginate;
import com.ecom.product_api.entity.Images;
import com.ecom.product_api.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Override
    public void createProduct(RequestProductDto dto, MultipartFile file) {

    }

    @Override
    public void updateProduct(RequestProductDto dto, String productId) {

    }

    @Override
    public void deleteProduct(String productId) {

    }

    @Override
    public ResponseProductDto fundProductById(String productId) {
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
