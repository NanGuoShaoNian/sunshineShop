package cn.sunshineShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunshineShop.common.bean.EUDataGridResult;
import cn.sunshineShop.common.bean.SunshineShopResult;
import cn.sunshineShop.pojo.TbItem;
import cn.sunshineShop.pojo.TbItemDesc;
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

	@RequestMapping("/item/save")
	@ResponseBody
	public SunshineShopResult saveItem(TbItem item, String desc) {

		TbItemDesc itemDesc = new TbItemDesc();

		itemDesc.setItemDesc(desc);

		return itemService.saveItem(item, itemDesc);
	}

	@RequestMapping("/item/delete")
	@ResponseBody
	public SunshineShopResult deleteItem(Long[] ids) {

		// 进行判空，防止这种情况出现
		if (ids == null || ids.length <= 0) {

			return SunshineShopResult.ok();
		}

		return itemService.deleteItemByIdOrBatchId(ids);
	}

}
