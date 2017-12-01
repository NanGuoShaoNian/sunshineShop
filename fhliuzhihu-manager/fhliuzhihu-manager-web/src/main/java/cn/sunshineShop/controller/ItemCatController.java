package cn.sunshineShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunshineShop.common.bean.EUTreeNode;
import cn.sunshineShop.service.ItemCatService;

/***
 * 商品类目层
 * 
 * @author liuzhihu
 *
 */

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	/***
	 * 获取类目
	 * 
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getItemCatList(@RequestParam(value = "id", defaultValue = "0") long parentId) {

		List<EUTreeNode> list = itemCatService.getItemCatList(parentId);

		return list;

	}

}
