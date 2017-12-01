package cn.sunshineShop.service;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sunshineShop.pojo.BasePojo;

/**
 * 抽象的baseservice
 * 
 * @author liuzhihu
 *
 */
public abstract class BaseService<T extends BasePojo> {

	/**
	 * 用于给子类实现
	 * 
	 * @return
	 */
	public abstract Mapper<T> getMapper();

	/***
	 * 通过id查询对应的bean
	 * 
	 * @param id
	 * @return
	 */
	public T queryById(Long id) {

		// 返回结果值
		return getMapper().selectByPrimaryKey(id);
	}

	/***
	 * 查询集合
	 * 
	 * @param t
	 * @return
	 */
	public List<T> queryList(T t) {

		// 返回结果值
		return getMapper().select(t);
	}

	/***
	 * 进行分页的查询
	 * 
	 * @param t
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageInfo<T> queryListPage(T t, Integer page, Integer rows) {

		// 进行分页
		PageHelper.startPage(page, rows);

		// 查询
		List<T> list = getMapper().select(t);

		// 返回结果值
		return new PageInfo<T>(list);
	}

	/***
	 * 查询数量
	 * 
	 * @param t
	 * @return
	 */
	public Integer queryCount(T t) {

		// 获取数量
		Integer count = getMapper().selectCount(t);

		// 返回结果值
		return count;
	}

	/***
	 * 新增
	 * 
	 * @param t
	 * @return
	 */
	public Integer save(T t) {

		// 返回结果值
		return getMapper().insert(t);
	}

	/***
	 * 新增数据，不为null作为参数
	 * 
	 * @param t
	 * @return
	 */
	public Integer saveSelective(T t) {

		// 返回结果值
		return getMapper().insertSelective(t);
	}

	/***
	 * 更新
	 * 
	 * @param t
	 * @return
	 */
	public Integer update(T t) {

		// 返回结果值
		return getMapper().updateByPrimaryKey(t);
	}

	/***
	 * 更新数据，不为null作为参数
	 * 
	 * @param t
	 * @return
	 */
	public Integer updateSelective(T t) {

		// 返回结果值
		return getMapper().updateByPrimaryKeySelective(t);
	}

	/***
	 * 根据主键删除数据
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteById(Long id) {

		// 返回结果值
		return getMapper().deleteByPrimaryKey(id);
	}

}
