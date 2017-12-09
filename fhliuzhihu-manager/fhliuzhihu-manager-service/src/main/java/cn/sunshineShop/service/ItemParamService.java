package cn.sunshineShop.service;

import cn.sunshineShop.common.bean.SunshineShopResult;
import cn.sunshineShop.pojo.TbItemParam;

public interface ItemParamService {
	
	public SunshineShopResult getItemParamByCid(long cid);
	
	public SunshineShopResult insertItemParam(TbItemParam itemParam);
}
