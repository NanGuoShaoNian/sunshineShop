package cn.sunshineShop.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import cn.sunshineShop.common.util.IDUtils;
import cn.sunshineShop.service.PicUploadService;

/***
 * 图片上传到七牛云
 * 
 * @author liuzhihu
 *
 */
public class PicUploadServiceImpl implements PicUploadService {

	@Override
	public String uploadPic(MultipartFile multipartFile) {

		// 原本的文件名
		String oldName = multipartFile.getOriginalFilename();

		//
		String newName = IDUtils.genImageName() + oldName;

		return newName;
	}

	Map<String, String> map = new HashMap<>(16);

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>(16);
		map.put("a", "1");
		System.out.println(Integer.parseInt(map.get("a")));
	}

}
