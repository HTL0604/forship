package htl.ute.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import htl.ute.controller.DBconnectionSQL;
import htl.ute.dao.ICategoryDao;
import htl.ute.model.CategoryModel;
import htl.ute.model.UserModel;

import java.sql.Connection;

public class CategoryDaoImpl extends DBconnectionSQL implements ICategoryDao {
	public Connection conn=null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		List<CategoryModel> list = new ArrayList();
		try {
			conn = super.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
			CategoryModel category =new CategoryModel();
			category.setCategoryid(rs.getInt("categoryid"));
			category.setCategoryname(rs.getString("categoryname"));
			category.setImages(rs.getString("images"));
			category.setStatus(rs.getInt("status"));
			list.add(category);
			}	
			conn.close();
			ps.close();
			rs.close();
		return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public CategoryModel findById(int id) {
		String sql = "SELECT * FROM category WHERE categoryid =?";
		try {
			conn = super.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			CategoryModel category =new CategoryModel();
			while(rs.next()) {
			category.setCategoryid(rs.getInt("categoryid"));
			category.setCategoryname(rs.getString("categoryname"));
			category.setImages(rs.getString("images"));
			category.setStatus(rs.getInt("status"));
			
			}	
			conn.close();
			ps.close();
			rs.close();
		return category;
		}catch(Exception e) {
			e.printStackTrace();
		}
			return null;
		}
	

	@Override
	public CategoryModel findByname(String name) {
		String sql = "SELECT * FROM category WHERE categoryname =?";
		try {
			conn = super.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			rs = ps.executeQuery();
			CategoryModel category =new CategoryModel();
			while(rs.next()) {
			category.setCategoryid(rs.getInt("categoryid"));
			category.setCategoryname(rs.getString("categoryname"));
			category.setImages(rs.getString("images"));
			category.setStatus(rs.getInt("status"));
			}	
			conn.close();
			ps.close();
			rs.close();
		return category;
		}catch(Exception e) {
			e.printStackTrace();
		}
			return null;
		}

	@Override
	public void insert(CategoryModel category) {
		String sql = "INSERT INTO category(categoryname, images, status) VALUES(?,?,?)";
		try {
			new DBconnectionSQL();
			conn = super.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();
			conn.close();
			ps.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(CategoryModel category) {
		String sql = "UPDATE category SET categoryname = ? ,images = ? , status = ? WHERE categoryid = ?";
		try {
			new DBconnectionSQL();
			conn = super.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCategoryid());
			ps.executeUpdate();
			conn.close();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM category WHERE categoryid=?";
		try {
			conn = super.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.close();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateStatus(int id, int status) {
		String sql = "update category set status=? where categoryid=? ";
		try {
			conn = super.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,status);
			ps.setInt(2,id);			
			rs = ps.executeQuery();
			conn.close();
			ps.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
