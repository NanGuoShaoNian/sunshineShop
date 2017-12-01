package cn.sunshineShop.service;

import cn.sunshineShop.common.bean.EUDataGridResult;
import cn.sunshineShop.pojo.TbItem;

/***
 * 业务层
 * 
 * @author liuzhihu
 *
 */
public interface ItemService {
	EUDataGridResult getItemList(int page, int rows);

	TbItem getItemById(Long itemId);
}
