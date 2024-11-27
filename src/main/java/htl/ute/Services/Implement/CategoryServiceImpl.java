package htl.ute.Services.Implement;

import java.util.List;

import htl.ute.Services.ICategoryService;
import htl.ute.dao.ICategoryDao;
import htl.ute.dao.impl.CategoryDaoImpl;
import htl.ute.model.CategoryModel;

public class CategoryServiceImpl implements ICategoryService {
	public ICategoryDao dao = new CategoryDaoImpl();
	@Override
	public List<CategoryModel> findAll() {
		return dao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {
		return dao.findById(id);
	}

	@Override
	public CategoryModel findByname(String name) {
		return dao.findByname(name);
	}

	@Override
	public void insert(CategoryModel category) {
		CategoryModel cate = this.findByname(category.getCategoryname());
		if(cate.getCategoryname()==null) {
			dao.insert(category);
		}
		
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cate = new CategoryModel();
		cate = dao.findById(cate.getCategoryid());
		if(cate !=null) {
		dao.update(category);
		}
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public void updateStatus(int id, int status) {
		dao.updateStatus(id, status);
	}

}
