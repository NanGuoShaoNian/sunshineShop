package cn.sunshineShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunshineShop.common.bean.EUDataGridResult;
import cn.sunshineShop.pojo.TbItem;
import cn.sunshineShop.service.ItemService;

/**
 * 商品管理
 * 
 * @author liuzhihu
 *
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {

		// 调用业务层
		EUDataGridResult euDataGridResult = itemService.getItemList(page, rows);

		// 返回对应的值
		return euDataGridResult;
	}

	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {

		// 通过id获取记录
		TbItem item = itemService.getItemById(itemId);

		// 返回对应的值
		return item;
	}

}
