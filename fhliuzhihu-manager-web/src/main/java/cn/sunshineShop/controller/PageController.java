package cn.sunshineShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 页面跳转
 * 
 * @author liuzhihu
 *
 */

@RequestMapping("page")
@Controller
public class PageController {

	/***
	 * 页面跳转
	 * 
	 * @param pageName
	 * @return
	 */
	@RequestMapping("{pageName}")
	public String toPage(@PathVariable("pageName") String pageName) {

		return pageName;
	}

}
