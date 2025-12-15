package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NhanVienDao;
import model.NhanVien;

/**
 * Servlet implementation class Admin_NhanVien
 */
@WebServlet("/admin-nhanvien")
public class Admin_NhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_NhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NhanVienDao dao = new NhanVienDao();
        String action = request.getParameter("action");

        if (action == null) {
            request.setAttribute("list", dao.findAll());
            request.getRequestDispatcher("admin-nhanvien.jsp").forward(request, response);
            return;
        }
        switch (action) {
        case "add":
            request.setAttribute("action", "insert");
            request.getRequestDispatcher("admin-nhanvien-form.jsp").forward(request, response);
            break;

        case "edit":
            String id = request.getParameter("id");
            request.setAttribute("nv", dao.findById(id));
            request.setAttribute("action", "update");
            request.getRequestDispatcher("admin-nhanvien-form.jsp").forward(request, response);
            break;

        case "delete":
            dao.delete(request.getParameter("id"));
            response.sendRedirect("admin-nhanvien");
            break;
        case "search":
            String key = request.getParameter("key");
            request.setAttribute("list", dao.search(key));
            request.getRequestDispatcher("admin-nhanvien.jsp").forward(request, response);
            break;


        default:
            request.setAttribute("list", dao.findAll());
            request.getRequestDispatcher("admin-nhanvien.jsp").forward(request, response);
            break;
    }
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
        NhanVienDao dao = new NhanVienDao();

        String maNV = request.getParameter("maNV");
        String hoTen = request.getParameter("hoTen");
        String mk = request.getParameter("mk");
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");
        String vaiTro = request.getParameter("vaiTro");
        String trangThai = request.getParameter("trangThai");

        NhanVien nv = new NhanVien(maNV, hoTen, mk, sdt, trangThai, vaiTro, email);

        if ("insert".equals(action)) {
            dao.insert(nv);
        } else {
            dao.update(nv);
        }

        response.sendRedirect("admin-nhanvien");
	}

}
