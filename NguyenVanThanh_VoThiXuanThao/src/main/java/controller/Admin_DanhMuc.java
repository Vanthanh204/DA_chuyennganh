package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DanhMucDao;
import model.DanhMuc;

/**
 * Servlet implementation class Admin_DanhMuc
 */
@WebServlet("/admin-danhmuc")
public class Admin_DanhMuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_DanhMuc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		DanhMucDao dmDao= new DanhMucDao();
		if(action == null) {
			action = "list";
		}
		switch (action) {
		case "add": 
			request.getRequestDispatcher("admin-danhmuc-form.jsp").forward(request, response);
            break;
		case "edit":
			String maDM = request.getParameter("madm");
			DanhMuc dm = dmDao.findById(maDM);
			request.setAttribute("dm", dm);
			request.getRequestDispatcher("admin-danhmuc-form.jsp").forward(request, response);
			break;
		case "delete":
			String id = request.getParameter("madm");
			dmDao.delete(id);
			response.sendRedirect("admin-danhmuc?action=list");
			break;
		case "search":
		    String key = request.getParameter("key");
		    List<DanhMuc> searchList = dmDao.search(key);
		    request.setAttribute("listDM", searchList);
		    request.getRequestDispatcher("admin-danhmuc.jsp").forward(request, response);
		    break;

		default:
			List<DanhMuc> list = dmDao.findAll();
            request.setAttribute("listDM", list);
            request.getRequestDispatcher("admin-danhmuc.jsp").forward(request, response);
            break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
        DanhMucDao dmDao = new DanhMucDao();

        if ("insert".equals(action)) {
            String ma = request.getParameter("maDM");
            String ten = request.getParameter("tenDM");

            DanhMuc dm = new DanhMuc(ma, ten);
            dmDao.insert(dm);

            response.sendRedirect("admin-danhmuc?action=list");
        }

        if ("update".equals(action)) {
            String ma = request.getParameter("maDM");
            String ten = request.getParameter("tenDM");

            DanhMuc dm = new DanhMuc(ma, ten);
            dmDao.update(dm);

            response.sendRedirect("admin-danhmuc?action=list");
        }
    }
}