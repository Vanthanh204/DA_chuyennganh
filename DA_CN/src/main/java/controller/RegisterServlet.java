package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KhachHangDao;
import model.KhachHang;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerservlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhachHangDao khDao= new KhachHangDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		KhachHang kh= new KhachHang();
		kh.setMaKH("KH"+ System.currentTimeMillis());
		kh.setHoTen(request.getParameter("hoten"));
		kh.setEmail(request.getParameter("email"));
		kh.setDiaChi(request.getParameter("diachi"));
		kh.setSdt(request.getParameter("sdt"));
		kh.setMk(request.getParameter("mk"));
		kh.setTrangThai("hoat dong");
		
		boolean ok= khDao.insert(kh);
		if(ok) {
			response.sendRedirect("login.jsp?register=success");
		}else {
			request.setAttribute("errors", "dang ky that bai");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		doGet(request, response);
	}

}
