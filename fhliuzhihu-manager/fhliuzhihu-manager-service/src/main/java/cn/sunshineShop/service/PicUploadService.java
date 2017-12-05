package cn.sunshineShop.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PicUploadService {

	@SuppressWarnings("rawtypes")
	Map uploadPic(MultipartFile multipartFile);

}
