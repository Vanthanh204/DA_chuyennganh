package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DanhMucDao;
import dao.SanPhamDao;
import model.DanhMuc;
import model.SanPham;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/userservlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SanPhamDao spDao = new SanPhamDao();
	    DanhMucDao dmDao = new DanhMucDao();

	    String madm = request.getParameter("madm");       
	    String keyword = request.getParameter("keyword");

	    List<SanPham> listSP;
	    if (keyword != null && !keyword.trim().isEmpty()) {
	        listSP = spDao.search(keyword.trim());
	    } else if (madm != null && !madm.isEmpty()) {
	        listSP = spDao.getByDanhMuc(madm);
	    } else {
	        listSP = spDao.findAll();
	    }
	    List<DanhMuc> listDM = dmDao.findAll();

	    request.setAttribute("listDM", listDM);
	    request.setAttribute("listSP", listSP);

	    request.getRequestDispatcher("user-home.jsp").forward(request, response);

		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
