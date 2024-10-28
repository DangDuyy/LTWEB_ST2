package vn.iotstar.services.implement;

import java.util.List;

import vn.iotstar.configs.DBConnectMySQL;
import vn.iotstar.dao.ICategoryDao;
import vn.iotstar.dao.implement.CategoryDaoImpl;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.services.ICategoryService;

public class CategoryServiceImpl extends DBConnectMySQL implements ICategoryService {

	public ICategoryDao cateDao = new CategoryDaoImpl();
	
	@Override
	public List<CategoryModel> findAll() {
		return cateDao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {
		return cateDao.findById(id);
	}

	@Override
	public void insert(CategoryModel category) {
		cateDao.insert(category);
		
	}

	@Override
	public void update(CategoryModel category) {
		
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(category.getCategoryid());
		
		if (cate != null) {
			cateDao.update(category);
		} 
	}

	@Override
	public void delete(int id) {

		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(id);
		
		if (cate != null) {
			cateDao.delete(id);
		}
		
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		return cateDao.findName(keyword);
	}

}
