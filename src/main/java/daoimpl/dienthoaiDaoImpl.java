package daoimpl;

import java.util.List;

import dao.dienthoaiDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.dienthoai;

public class dienthoaiDaoImpl implements dienthoaiDao{

	private EntityManager entityManager;
	
	public dienthoaiDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public dienthoaiDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public dienthoai adddt(dienthoai dt) {
		// TODO Auto-generated method stub
		
		EntityTransaction trans=entityManager.getTransaction();
		
		try {
			
			trans.begin();
			entityManager.persist(dt);
			trans.commit();
			return dt;
		} catch (Exception e) {
			if(trans!=null && trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return dt;
	}

	@Override
	public dienthoai updatedt(dienthoai dt) {
		// TODO Auto-generated method stub
		
		EntityTransaction trans= entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.merge(dt);
			
			trans.commit();
			return dt;
		} catch (Exception e) {
			// TODO: handle exception
			if(trans!=null && trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(int maDT) {
		// TODO Auto-generated method stub
		EntityTransaction trans= entityManager.getTransaction();
		try {
			trans.begin();
			dienthoai dt= entityManager.find(dienthoai.class, maDT);
			entityManager.remove(dt);
			trans.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(trans!=null&& trans.isActive()) {
				trans.rollback();
			}
		}
		return false;
	}

	@Override
	public List<dienthoai> getAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from dienthoai",dienthoai.class).getResultList();
	}

	@Override
	public dienthoai findDtById(int maDT) {
		// TODO Auto-generated method stub
		return entityManager.find(dienthoai.class, maDT);
	}
	public List<dienthoai> searchByTen(String ten) {
	    // Thêm ký tự '%' vào đầu và cuối của tham số `ten`
	    String searchParam = "%" + ten.toLowerCase() + "%";
	    String jpql = "SELECT d FROM dienthoai d WHERE LOWER(d.tendt) LIKE :ten";
	    
	    return entityManager.createQuery(jpql, dienthoai.class)
	                        .setParameter("ten", searchParam)
	                        .getResultList();
	}

}
