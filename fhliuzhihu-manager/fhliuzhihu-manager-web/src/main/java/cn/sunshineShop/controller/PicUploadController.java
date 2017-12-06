package cn.sunshineShop.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.sunshineShop.common.util.JsonUtils;
import cn.sunshineShop.service.PicUploadService;

/****
 * 图片上传
 * 
 * @author liuzhihu
 *
 */
@Controller
@RequestMapping("/pic")
public class PicUploadController {

	@Autowired
	private PicUploadService picUploadService;

	@SuppressWarnings("rawtypes")
	@RequestMapping("/upload")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile) {
		Map result = picUploadService.uploadPic(uploadFile);
		// 为了保证功能的兼容性，需要把Result转换成json格式的字符串。
		String json = JsonUtils.objectToJson(result);
		return json;
	}

}
