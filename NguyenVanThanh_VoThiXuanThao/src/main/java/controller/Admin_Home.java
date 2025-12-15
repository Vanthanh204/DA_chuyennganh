package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChiTietDonHangDao;
import dao.DonHangDao;

/**
 * Servlet implementation class Admin_Home
 */
@WebServlet("/admin-home")
public class Admin_Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 DonHangDao dhDao = new DonHangDao();
	        ChiTietDonHangDao ctDao = new ChiTietDonHangDao();

	        long tongDoanhThu = dhDao.getTongDoanhThu();
	        long soDon = dhDao.getSoLuongDon();
	        long tongSPBan = ctDao.getTongSanPhamBan();

	        request.setAttribute("tongDoanhThu", tongDoanhThu);
	        request.setAttribute("soDon", soDon);
	        request.setAttribute("tongSPBan", tongSPBan);

	        request.getRequestDispatcher("admin-home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
