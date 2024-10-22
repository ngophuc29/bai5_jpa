package controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import models.dienthoai;
import models.nhacungcap;
import qldt.utils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import dao.dienthoaiDao;
import dao.nhaCungCapDao;
import daoimpl.dienthoaiDaoImpl;
import daoimpl.nhacungcapDaoImpl;

/**
 * Servlet implementation class DienthoaiControllers
 */
public class DienthoaiControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EntityManagerFactoryUtil entityManagerFactory;
	private dienthoaiDao dienthoaiDao;
	private nhaCungCapDao nhacungcapdao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DienthoaiControllers() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		entityManagerFactory = new EntityManagerFactoryUtil();
		nhacungcapdao = new nhacungcapDaoImpl(entityManagerFactory.getEnManager());
		dienthoaiDao = new dienthoaiDaoImpl(entityManagerFactory.getEnManager());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String searchTerm = request.getParameter("searchTerm"); // Lấy tham số tìm kiếm

		if (action != null) {
			switch (action) {
			case "add":
				List<nhacungcap> ncc = nhacungcapdao.getAll();
				request.setAttribute("ncc", ncc);
				request.getRequestDispatcher("/view/addDienThoai.jsp").forward(request, response);
				break;

			case "update":
				int madt = Integer.parseInt(request.getParameter("madt"));
				dienthoai dtUpdate = dienthoaiDao.findDtById(madt);
				request.setAttribute("dtUpdate", dtUpdate);

				List<nhacungcap> nccU = nhacungcapdao.getAll();
				request.setAttribute("ncc", nccU);
				request.getRequestDispatcher("/view/capNhatDienThoai.jsp").forward(request, response);
				break;

			case "xoa":
				int madtXoa = Integer.parseInt(request.getParameter("madt"));
				dienthoaiDao.delete(madtXoa);
				List<dienthoai> listUser = dienthoaiDao.getAll();
				request.setAttribute("listUser", listUser);
				request.getRequestDispatcher("/view/danhsachDienThoai.jsp").forward(request, response);
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
			}
		} else {
			List<dienthoai> listUser;

			// Nếu có tham số tìm kiếm, gọi phương thức tìm kiếm
			if (searchTerm != null && !searchTerm.trim().isEmpty()) {
				listUser = dienthoaiDao.searchByTen(searchTerm); // Gọi phương thức tìm kiếm
			} else {
				listUser = dienthoaiDao.getAll(); // Lấy tất cả nếu không có tham số tìm kiếm
			}

			request.setAttribute("listUser", listUser);
			request.getRequestDispatcher("/view/danhsachDienThoai.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action != null) {
			switch (action) {
			case "update":
				int madt = Integer.parseInt(request.getParameter("madt"));
				String ten = request.getParameter("ten");

				// Kiểm tra tham số "nam"
				String namStr = request.getParameter("nam");
				if (namStr == null || namStr.trim().isEmpty()) {
					request.setAttribute("error", "Năm sản xuất không được để trống");
					request.getRequestDispatcher("/view/capNhatDienThoai.jsp").forward(request, response);
					return; // Dừng thực hiện tiếp
				}
				int nam = Integer.parseInt(namStr);

				String cauhinh = request.getParameter("cauhinh");

				// Kiểm tra tham số "mancc"
				String manccStr = request.getParameter("mancc");
				if (manccStr == null || manccStr.trim().isEmpty()) {
					request.setAttribute("error", "Mã nhà cung cấp không được để trống");
					request.getRequestDispatcher("/view/capNhatDienThoai.jsp").forward(request, response);
					return; // Dừng thực hiện tiếp
				}
				int mancc = Integer.parseInt(manccStr);

				nhacungcap ncc = nhacungcapdao.findDtById(mancc);
				dienthoai dt = new dienthoai(madt, ten, nam, cauhinh, ncc);

				dienthoaiDao.updatedt(dt);
				List<dienthoai> listUser = dienthoaiDao.getAll();
				request.setAttribute("listUser", listUser);
				request.getRequestDispatcher("/view/danhsachDienThoai.jsp").forward(request, response);
				break;

			// Các trường hợp khác...
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
			}
		} else {
			// Xử lý thêm sản phẩm
			String ten = request.getParameter("ten");

			// Kiểm tra tham số "nam"
			String namStr = request.getParameter("nam");
			if (namStr == null || namStr.trim().isEmpty()) {
				request.setAttribute("error", "Năm sản xuất không được để trống");
				List<nhacungcap> nccz = nhacungcapdao.getAll();
				request.setAttribute("ncc", nccz);
				request.getRequestDispatcher("/view/addDienThoai.jsp").forward(request, response);
				return; // Dừng thực hiện tiếp
			}
			int nam = Integer.parseInt(namStr);

			String cauhinh = request.getParameter("cauhinh");

			// Kiểm tra tham số "mancc"
			String manccStr = request.getParameter("mancc");
			if (manccStr == null || manccStr.trim().isEmpty()) {
				request.setAttribute("error", "Mã nhà cung cấp không được để trống");
				List<nhacungcap> nccz = nhacungcapdao.getAll();
				request.setAttribute("ncc", nccz);
				request.getRequestDispatcher("/view/addDienThoai.jsp").forward(request, response);
				return; // Dừng thực hiện tiếp
			}
			int mancc = Integer.parseInt(manccStr);
			nhacungcap ncc = nhacungcapdao.findDtById(mancc);

			dienthoai dt = new dienthoai(ten, nam, cauhinh, ncc);

			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			Set<ConstraintViolation<dienthoai>> violations = validator.validate(dt);

			if (violations.isEmpty()) {
				dienthoaiDao.adddt(dt);
				List<dienthoai> listUser = dienthoaiDao.getAll();
				request.setAttribute("listUser", listUser);
				request.getRequestDispatcher("/view/danhsachDienThoai.jsp").forward(request, response);
			} else {
				StringBuilder stringBuilder = new StringBuilder();
				violations.forEach(validation -> {
					stringBuilder.append(validation.getPropertyPath()).append(": ").append(validation.getMessage())
							.append("<br />");
				});
				List<nhacungcap> nccz = nhacungcapdao.getAll();
				request.setAttribute("ncc", nccz);
				request.setAttribute("error", stringBuilder.toString());
				request.getRequestDispatcher("/view/addDienThoai.jsp").forward(request, response);
			}
		}
	}

}
