//package com.compulynx.compas.bal.impl;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.compulynx.compas.bal.UploadSmartTransactionMstBal;
//import com.compulynx.compas.bal.UploadclaimBal;
//import com.compulynx.compas.dal.UploadSmartclaimDal;
//import com.compulynx.compas.models.SmartTransactionMst;
//import com.compulynx.compas.models.CompasResponse;
//
//public class UploadSmartTransactionMstBalImpl implements UploadSmartTransactionMstBal{
//	@Autowired
//	UploadSmartclaimDal smartclaimDal;
//	private final String UPLOAD_DIR = "/uploads/uploadedclaims";
//	@Override
//	public boolean addUploadSmartclaimDocument(String orgId, MultipartFile file) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
//	private String saveUploadedFile(MultipartFile file) throws IOException {
//        File uploadDir = new File(UPLOAD_DIR);
//        uploadDir.mkdirs();
// 
//        StringBuilder sb = new StringBuilder();
// 
//        if(!file.isEmpty()) {
//            String uploadFilePath = UPLOAD_DIR + "/" + file.getOriginalFilename();
// 
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(uploadFilePath);
//            Files.write(path, bytes);
//            sb.append(uploadFilePath).append(", ");
//        }
//        return sb.toString();
//    }
//
//	@Override
//	public CompasResponse UploadService(String filePath) {
//		// TODO Auto-generated method stub
//		return smartclaimDal.uploadSmartClaim(filePath);
//	}
//
//}
