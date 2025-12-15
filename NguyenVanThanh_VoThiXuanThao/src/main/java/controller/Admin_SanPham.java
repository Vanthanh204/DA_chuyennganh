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
 * Servlet implementation class Admin_SanPham
 */
@WebServlet("/admin-sanpham")
public class Admin_SanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_SanPham() {
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

		String action= request.getParameter("action");
		SanPhamDao spDao = new SanPhamDao();
		DanhMucDao dmDao = new DanhMucDao();
		if (action ==null) {
			action = "list";
		} switch (action) {
		case "add":
			request.setAttribute("listDM", dmDao.findAll());
			request.getRequestDispatcher("admin-sanpham-form.jsp").forward(request, response);
			break;
		case "edit":
			String maSP= request.getParameter("masp");
			SanPham sp= spDao.findById(maSP);
			request.setAttribute("sp", sp);
			request.setAttribute("listDM", dmDao.findAll());
			request.getRequestDispatcher("admin-sanpham-form.jsp").forward(request, response);
			break;
		case "delete":
			String id= request.getParameter("masp");
			spDao.delete(id);
			response.sendRedirect("admin-sanpham?action=list");
			break;
		case "search":
			String key = request.getParameter("key");
			List<SanPham> searchList= spDao.search(key);
			request.setAttribute("listSP", searchList);
			request.getRequestDispatcher("admin-sanpham.jsp").forward(request, response);
			break;

		default:
			List<SanPham> list = spDao.findAll();
			request.setAttribute("listSP", list);
			request.getRequestDispatcher("admin-sanpham.jsp").forward(request, response);
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
        SanPhamDao spDao = new SanPhamDao();

        if ("insert".equals(action)) {

            String ma = request.getParameter("maSP");
            String ten = request.getParameter("tenSP");
            String maDM = request.getParameter("danhMuc");
            DanhMuc dm = new DanhMucDao().findById(maDM);
            String mota = request.getParameter("moTa");
            String cauhinh = request.getParameter("cauHinh");
            String mausac = request.getParameter("mauSac");
            String dungluong = request.getParameter("dungLuong");
            String hangsx = request.getParameter("hangSX");

            int giaBan = Integer.parseInt(request.getParameter("giaBan"));
            String trangthai = request.getParameter("trangThai");

            SanPham sp = new SanPham(ma, ten, dm, mota, cauhinh, mausac, dungluong, hangsx, giaBan, trangthai);

            spDao.insert(sp);
            response.sendRedirect("admin-sanpham?action=list");
        }


        if ("update".equals(action)) {

            String ma = request.getParameter("maSP");
            String ten = request.getParameter("tenSP");

            String maDM = request.getParameter("danhMuc");
            DanhMuc dm = new DanhMucDao().findById(maDM);

            String mota = request.getParameter("moTa");
            String cauhinh = request.getParameter("cauHinh");
            String mausac = request.getParameter("mauSac");
            String dungluong = request.getParameter("dungLuong");
            String hangsx = request.getParameter("hangSX");

            int giaBan = Integer.parseInt(request.getParameter("giaBan"));
            String trangthai = request.getParameter("trangThai");

            SanPham sp = new SanPham(ma, ten, dm, mota, cauhinh, mausac, dungluong, hangsx, giaBan, trangthai);

            spDao.update(sp);
            response.sendRedirect("admin-sanpham?action=list");
        }
	}
}