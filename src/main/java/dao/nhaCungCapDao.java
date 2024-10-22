package dao;

import java.util.List;

import models.dienthoai;
import models.nhacungcap;

public interface nhaCungCapDao {
	public nhacungcap adddt(nhacungcap ncc);
	public nhacungcap updatedt(nhacungcap ncc);
	public boolean delete(int id);
	public List<nhacungcap>getAll();
	public nhacungcap findDtById(int mancc);
}
