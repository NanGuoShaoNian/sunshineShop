package cn.sunshineShop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunshineShop.common.bean.EUTreeNode;
import cn.sunshineShop.mapper.TbItemCatMapper;
import cn.sunshineShop.pojo.TbItemCat;
import cn.sunshineShop.pojo.TbItemCatExample;
import cn.sunshineShop.pojo.TbItemCatExample.Criteria;
import cn.sunshineShop.service.ItemCatService;

/***
 * 商品类目
 * 
 * @author liuzhihu
 *
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<EUTreeNode> getItemCatList(long parentId) {

		TbItemCatExample example = new TbItemCatExample();

		Criteria criteria = example.createCriteria();

		criteria.andParentIdEqualTo(parentId);

		List<TbItemCat> itemCats = itemCatMapper.selectByExample(example);

		List<EUTreeNode> euTreeNodeList = new ArrayList<>(16);

		for (TbItemCat cat : itemCats) {

			EUTreeNode euTreeNode = new EUTreeNode();
			euTreeNode.setId(cat.getId());
			euTreeNode.setText(cat.getName());
			euTreeNode.setState(cat.getIsParent() ? "closed" : "open");

			euTreeNodeList.add(euTreeNode);

		}

		return euTreeNodeList;
	}

}
