package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KhoDao;
import dao.SanPhamDao;
import model.Kho;

/**
 * Servlet implementation class Admin_Kho
 */
@WebServlet("/admin-kho")
public class Admin_Kho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Kho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		KhoDao dao = new KhoDao();
        SanPhamDao spDao = new SanPhamDao();

        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {

            case "add":
                request.setAttribute("listSP", spDao.findAll());
                request.getRequestDispatcher("admin-kho-form.jsp").forward(request, response);
                break;

            case "edit":
                String maKho = request.getParameter("maKho");
                request.setAttribute("kho", dao.findById(maKho));
                request.setAttribute("listSP", spDao.findAll());
                request.getRequestDispatcher("admin-kho-form.jsp").forward(request, response);
                break;

            case "delete":
                dao.delete(request.getParameter("maKho"));
                response.sendRedirect("admin-kho");
                break;
            case "search":
                String key = request.getParameter("key");
                if (key == null || key.trim().isEmpty()) {
                    request.setAttribute("listKho", dao.findAll());
                } else {
                    request.setAttribute("listKho", dao.search(key));
                }
                request.getRequestDispatcher("admin-kho.jsp").forward(request, response);
                break;

            default:
                request.setAttribute("listKho", dao.findAll());
                request.getRequestDispatcher("admin-kho.jsp").forward(request, response);
                break;
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		KhoDao dao = new KhoDao();
        SanPhamDao spDao = new SanPhamDao();

        String maKho = request.getParameter("maKho");
        String maSP = request.getParameter("maSP");
        int soLuong = Integer.parseInt(request.getParameter("soLuongTon"));
        String ngay = request.getParameter("ngayCapNhat");

        Kho kho = new Kho(
                maKho,
                spDao.findById(maSP),
                soLuong,
                java.sql.Date.valueOf(ngay)
        );

        dao.save(kho);

        response.sendRedirect("admin-kho");
    }
}


