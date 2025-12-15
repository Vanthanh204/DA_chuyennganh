package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DonHangDao;
import dao.KhachHangDao;
import model.KhachHang;

/**
 * Servlet implementation class Admin_Khach
 */
@WebServlet("/admin-khach")
public class Admin_Khach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Khach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
     
		String action= request.getParameter("action");
		KhachHangDao khDao=new KhachHangDao();
		if(action == null) {
				action = "list";
			}
		switch (action) {
		case "list":
            List<KhachHang> list = khDao.findAll();
            request.setAttribute("listKH", list);
            request.getRequestDispatcher("admin-khach.jsp").forward(request, response);
            break;
		case "add":
            request.getRequestDispatcher("admin-khach-form.jsp").forward(request, response);
            break;
		case "edit":
            String maKH = request.getParameter("maKH");
            KhachHang kh = khDao.findById(maKH);
            request.setAttribute("kh", kh);
            request.getRequestDispatcher("admin-khach-form.jsp").forward(request, response);
            break;
		case "delete":
	        String id = request.getParameter("maKH");
	        khDao.delete(id);
	        response.sendRedirect("admin-khach?action=list");
	        break;
		case "search":
            String key = request.getParameter("key");

            if (key == null || key.trim().isEmpty()) {
                request.setAttribute("listKH", khDao.findAll());
            } else {
                request.setAttribute("listKH", khDao.search(key));
            }

            request.getRequestDispatcher("admin-khach.jsp").forward(request, response);
            break;

        default:
            response.sendRedirect("admin-khach?action=list");
            break;
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
	        response.setCharacterEncoding("UTF-8");

	        String action = request.getParameter("action");  // lấy action từ form
	        KhachHangDao khDao = new KhachHangDao();

	        String ma = request.getParameter("maKH");
	        String ten = request.getParameter("hoTen");
	        String diachi = request.getParameter("diaChi");
	        String email = request.getParameter("email");
	        String trangthai = request.getParameter("trangThai");
	        String mk = request.getParameter("mk");
	        String sdt = request.getParameter("sdt");

	        KhachHang kh = new KhachHang(ma, ten, diachi, email, trangthai, mk, sdt);

	        if ("insert".equals(action)) {
	            khDao.insert(kh);
	        } else if ("update".equals(action)) {
	            khDao.update(kh);
	        }

	        response.sendRedirect("admin-khach?action=list");
	    }
}