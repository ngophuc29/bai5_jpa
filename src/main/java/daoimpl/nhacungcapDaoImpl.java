package daoimpl;

import java.util.List;

import dao.nhaCungCapDao;
import jakarta.persistence.EntityManager;
import models.nhacungcap;

public class nhacungcapDaoImpl implements nhaCungCapDao{

	
	private EntityManager entityManager;
	
	public nhacungcapDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public nhacungcap adddt(nhacungcap ncc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public nhacungcap updatedt(nhacungcap ncc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<nhacungcap> getAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from nhacungcap",nhacungcap.class).getResultList();
	}

	@Override
	public nhacungcap findDtById(int mancc) {
		// TODO Auto-generated method stub
		return entityManager.find(nhacungcap.class, mancc);
	}

}
