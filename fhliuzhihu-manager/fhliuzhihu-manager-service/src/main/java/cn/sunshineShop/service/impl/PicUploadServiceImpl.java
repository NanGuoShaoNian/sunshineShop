package cn.sunshineShop.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.sunshineShop.common.util.FtpUtil;
import cn.sunshineShop.common.util.IDUtils;
import cn.sunshineShop.service.PicUploadService;

/***
 * 图片上传到七牛云
 * 
 * @author liuzhihu
 *
 */

@Service
public class PicUploadServiceImpl implements PicUploadService {

	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map uploadPic(MultipartFile multipartFile) {

		Map resultMap = new HashMap<>();
		try {
			// 生成一个新的文件名
			// 取原始文件名
			String oldName = multipartFile.getOriginalFilename();
			// 生成新文件名
			// UUID.randomUUID();
			String newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			// 图片上传
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, "/",
					newName, multipartFile.getInputStream());
			// 返回结果
			if (!result) {
				resultMap.put("error", 1);
				resultMap.put("message", "文件上传失败");
				return resultMap;
			}
			resultMap.put("error", 0);
			resultMap.put("url", IMAGE_BASE_URL + "/" + newName);
			return resultMap;

		} catch (Exception e) {
			resultMap.put("error", 1);
			resultMap.put("message", "文件上传发生异常");
			return resultMap;
		}
	}
}
