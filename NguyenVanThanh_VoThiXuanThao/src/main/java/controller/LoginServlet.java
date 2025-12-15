package controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KhachHangDao;
import dao.NhanVienDao;
import model.KhachHang;
import model.NhanVien;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sdt = request.getParameter("username");
        String mk = request.getParameter("password");

        NhanVienDao nvDao = new NhanVienDao();
        NhanVien nv = nvDao.login(sdt, mk);

        if (nv != null) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", nv); 
            response.sendRedirect("admin-home.jsp");
            return;
        }

        // Khách hàng
        KhachHangDao khDao = new KhachHangDao();
        KhachHang kh = khDao.login(sdt, mk);

        if (kh != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", kh);
            response.sendRedirect("userservlet");
            return;
        }

        request.setAttribute("msg", "Sai thông tin đăng nhập!");
        request.getRequestDispatcher("login.jsp").forward(request, response);
	}
 
}
