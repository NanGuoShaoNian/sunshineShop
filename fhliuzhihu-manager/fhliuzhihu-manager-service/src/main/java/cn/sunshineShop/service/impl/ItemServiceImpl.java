package cn.sunshineShop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sunshineShop.common.bean.EUDataGridResult;
import cn.sunshineShop.common.bean.SunshineShopResult;
import cn.sunshineShop.common.util.ExceptionUtil;
import cn.sunshineShop.common.util.IDUtils;
import cn.sunshineShop.mapper.TbItemDescMapper;
import cn.sunshineShop.mapper.TbItemMapper;
import cn.sunshineShop.pojo.TbItem;
import cn.sunshineShop.pojo.TbItemDesc;
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

	@Autowired
	private TbItemDescMapper descMapper;

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

	@Override
	public SunshineShopResult saveItem(TbItem item, TbItemDesc itemDesc) {

		Date date = new Date();

		// 商品的itemId
		Long itemId = IDUtils.genItemId();

		// 补全商品数据
		item.setId(itemId);
		item.setStatus((byte) 1);
		item.setCreated(date);
		item.setUpdated(date);

		// 补全商品描述数据
		itemDesc.setItemId(itemId);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);

		try {
			// 把数据插入到商品表
			tbItemMapper.insert(item);

			// 把数据插入到商品描述表
			descMapper.insert(itemDesc);
		} catch (Exception e) {

			e.printStackTrace();

			return SunshineShopResult.build(500, ExceptionUtil.getStackTrace(e));

		}

		return SunshineShopResult.ok();
	}

	@Override
	public SunshineShopResult deleteItemByIdOrBatchId(Long[] ids) {

		try {
			for (Long itemId : ids) {
				tbItemMapper.deleteByPrimaryKey(itemId);
				descMapper.deleteByPrimaryKey(itemId);
			}
		} catch (Exception e) {
			e.printStackTrace();

			return SunshineShopResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return SunshineShopResult.ok();
	}

	@Override
	public SunshineShopResult updateItem(TbItem item, String desc) {

		Date upDate = new Date();

		try {
			// 通过主键，查询数据中存在的记录
			TbItem tbItem = tbItemMapper.selectByPrimaryKey(item.getId());

			TbItemDesc tbItemDesc = descMapper.selectByPrimaryKey(item.getId());

			tbItem.setBarcode(item.getBarcode());
			tbItem.setCid(item.getCid());
			tbItem.setImage(item.getImage());
			tbItem.setNum(item.getNum());
			tbItem.setPrice(item.getPrice());
			tbItem.setSellPoint(item.getSellPoint());
			tbItem.setTitle(item.getTitle());
			tbItem.setUpdated(upDate);

			tbItemDesc.setItemDesc(desc);
			tbItemDesc.setUpdated(upDate);

			tbItemMapper.updateByPrimaryKey(tbItem);

			descMapper.updateByPrimaryKey(tbItemDesc);
		} catch (Exception e) {
			e.printStackTrace();

			return SunshineShopResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return SunshineShopResult.ok();
	}

}
