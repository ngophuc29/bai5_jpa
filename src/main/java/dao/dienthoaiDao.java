package dao;

import java.util.List;

import models.dienthoai;

public interface dienthoaiDao {

	public dienthoai adddt(dienthoai dt);
	public dienthoai updatedt(dienthoai dt);
	public boolean delete(int id);
	public List<dienthoai>getAll();
	public dienthoai findDtById(int id);
	public List<dienthoai> searchByTen(String ten);
}
