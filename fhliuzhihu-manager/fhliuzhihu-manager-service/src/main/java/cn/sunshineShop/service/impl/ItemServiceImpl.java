package cn.sunshineShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sunshineShop.common.bean.EUDataGridResult;
import cn.sunshineShop.mapper.TbItemMapper;
import cn.sunshineShop.pojo.TbItem;
import cn.sunshineShop.pojo.TbItemExample;
import cn.sunshineShop.service.ItemService;

/***
 * 业务层实现
 * 
 * @author liuzhihu
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;

	/**
	 * 获取商品列表
	 */
	public EUDataGridResult getItemList(int page, int rows) {

		// 查询商品列表
		TbItemExample example = new TbItemExample();
		// 分页处理
		PageHelper.startPage(page, rows);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		// 创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		// 取记录总条数
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	/**
	 * 通过id获取对应的商品
	 */
	public TbItem getItemById(Long itemId) {

		TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);

		return tbItem;
	}

}
