package cn.sunshineShop.service;

import java.util.List;

import cn.sunshineShop.common.bean.EUTreeNode;

public interface ItemCatService {

	List<EUTreeNode> getItemCatList(long parentId);

}
