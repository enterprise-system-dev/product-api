package com.ecom.product_api.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.ecom.product_api.dto.CommonFileSavedBinaryDataDto;
import com.ecom.product_api.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final AmazonS3 amazonS3;
    private final AmazonS3Client amazonS3Client;


    @Override
    public CommonFileSavedBinaryDataDto create(MultipartFile file, String directory, String bucket) throws IOException, SQLException {
        String originalFileName = file.getOriginalFilename();
        String newFileName = UUID.randomUUID() + "_" + originalFileName;
        PutObjectResult putObjectResult = amazonS3Client.putObject(
                new PutObjectRequest(bucket, directory + newFileName,
                        file.getInputStream(),
                        new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead)
        );
        return CommonFileSavedBinaryDataDto.builder()
                .directory(new SerialBlob(directory.getBytes()))
                .fileName(new SerialBlob(newFileName.getBytes()))
                .hash(new SerialBlob(putObjectResult.getContentMd5().getBytes()))
                .resourceUrl(new SerialBlob(amazonS3Client.getResourceUrl(bucket, directory + newFileName).getBytes()))
                .build();

    }

    @Override
    public void delete(String directory, String fileName, String bucket) {
            amazonS3Client.deleteObject(bucket,directory+fileName); // abc/xyz/abc.png
    }
}
