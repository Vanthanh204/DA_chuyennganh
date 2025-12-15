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
 * Servlet implementation class DangKyServlet
 */
@WebServlet("/DangKyServlet")
public class DangKyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("dangky.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hoten = request.getParameter("hoten");
        String sdt = request.getParameter("sdt");
        String mk = request.getParameter("mk");
        String mk2 = request.getParameter("mk2");

        //kiem tra mat khau nhap lai
        if(!mk.equals(mk2)) {
            request.setAttribute("msg", "Mật khẩu không trùng khớp");
            request.getRequestDispatcher("dangky.jsp").forward(request, response);
            return;
        }
        
        KhachHang kh = new KhachHang();
        kh.setHoTen(hoten);
        kh.setSdt(sdt);
        kh.setMk(mk);

        KhachHangDao dao = new KhachHangDao();
        boolean success = dao.insert(kh);
        if(success) {
            request.setAttribute("msg_success", "Đăng ký thành công! Mời đăng nhập.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "Số điện thoại đã tồn tại!");
            request.getRequestDispatcher("dangky.jsp").forward(request, response);
        }
		
	}

}
