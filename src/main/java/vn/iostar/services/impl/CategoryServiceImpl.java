package vn.iostar.services.impl;

import java.util.List;

import vn.iostar.dao.ICategoryDao;
import vn.iostar.dao.impl.CategoryDao;
import vn.iostar.entity.Category;
import vn.iostar.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {

	public ICategoryDao cateDao = new CategoryDao();

	@Override
	public void insert(Category category) {
		Category cate = this.findByCategoryname(category.getCategoryname());
		if (cate == null) {
			cateDao.insert(category);
		}

	}

	@Override
	public int count() {
		return cateDao.count();
	}

	@Override
	public List<Category> findAll(int page, int pagesize) {
		return cateDao.findAll(page, pagesize);
	}

	@Override
	public List<Category> searchByName(String catname) {
		return cateDao.searchByName(catname);
	}

	@Override
	public List<Category> findAll() {
		return cateDao.findAll();
	}

	@Override
	public Category findById(int cateid) {
		return cateDao.findById(cateid);
	}

	@Override
	public void delete(int cateid) throws Exception {
		try {
			cateDao.delete(cateid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Category category) {
		Category cate = this.findById(category.getCategoryId());
		if (cate != null) {
			cateDao.update(category);
		}

	}

	@Override
	public Category findByCategoryname(String name) {
		try {
			return cateDao.findByCategoryname(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
