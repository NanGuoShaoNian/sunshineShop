package cn.sunshineShop.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	/***
	 * 页面跳转
	 * 
	 * @param pageName
	 * @return
	 */
	@RequestMapping("/index")
	public String showIndex() throws Exception {
		return "index";
	}

}
