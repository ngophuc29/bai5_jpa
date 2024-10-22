package controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.nhacungcap;
import qldt.utils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.util.List;

import dao.nhaCungCapDao;
import daoimpl.nhacungcapDaoImpl;

/**
 * Servlet implementation class nhaCungCapController
 */
public class nhaCungCapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EntityManagerFactoryUtil entityManagerfactory;
	private nhaCungCapDao nhacungcapDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nhaCungCapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		entityManagerfactory= new EntityManagerFactoryUtil();
		nhacungcapDao= new nhacungcapDaoImpl(entityManagerfactory.getEnManager());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<nhacungcap>listncc=nhacungcapDao.getAll();
		request.setAttribute("listncc", listncc);
		System.out.println("danh sach nha cung cap : " + listncc);
		request.getRequestDispatcher("/view/danhsachNCC.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
