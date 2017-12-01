package cn.sunshineShop.service;

import org.springframework.web.multipart.MultipartFile;

public interface PicUploadService {

	String uploadPic(MultipartFile multipartFile);

}
