package cn.sunshineShop.service;

import cn.sunshineShop.common.bean.EUDataGridResult;
import cn.sunshineShop.common.bean.SunshineShopResult;
import cn.sunshineShop.pojo.TbItem;
import cn.sunshineShop.pojo.TbItemDesc;

/***
 * 业务层
 * 
 * @author liuzhihu
 *
 */
public interface ItemService {
	EUDataGridResult getItemList(int page, int rows);

	TbItem getItemById(Long itemId);

	SunshineShopResult saveItem(TbItem item, TbItemDesc itemDesc);

	SunshineShopResult deleteItemByIdOrBatchId(Long[] ids);
}
