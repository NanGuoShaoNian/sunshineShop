package cn.sunshineShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunshineShop.common.bean.SunshineShopResult;
import cn.sunshineShop.pojo.TbContent;
import cn.sunshineShop.service.ContentService;

/**
 * 内容管理Controller
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;

	@RequestMapping("/save")
	@ResponseBody
	public SunshineShopResult insertContent(TbContent content) {
		SunshineShopResult result = contentService.insertContent(content);
		return result;
	}
}
