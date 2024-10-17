package com.ecom.product_api.service.impl;

import com.ecom.product_api.dto.CommonFileSavedBinaryDataDto;
import com.ecom.product_api.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public CommonFileSavedBinaryDataDto create(MultipartFile file, String directory, String bucket) {
        return null;
    }

    @Override
    public void delete(String directory, String fileName, String bucket) {

    }
}
