package cn.sunshineShop.service;

import java.util.List;

import cn.sunshineShop.common.bean.EUTreeNode;
import cn.sunshineShop.common.bean.SunshineShopResult;

public interface ContentCategoryService {

	List<EUTreeNode> getCategoryList(long parentId);

	SunshineShopResult insertContentCategory(long parentId, String name);
}
