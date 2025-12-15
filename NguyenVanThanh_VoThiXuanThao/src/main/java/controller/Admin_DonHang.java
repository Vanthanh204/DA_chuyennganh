package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChiTietDonHangDao;
import dao.DonHangDao;
import dao.KhachHangDao;
import dao.NhanVienDao;
import dao.SanPhamDao;
import model.ChiTietDonHang;
import model.DonHang;

/**
 * Servlet implementation class Admin_DonHang
 */
@WebServlet("/admin-donhang")
public class Admin_DonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_DonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
        DonHangDao dhDao = new DonHangDao();
        if(action == null) {
			action = "list";
		}
        switch (action) {
		case "view":
			 String ma = request.getParameter("maDH");
             ChiTietDonHangDao ctDao = new ChiTietDonHangDao();
             request.setAttribute("dh", dhDao.findById(ma));
             request.setAttribute("listCT", ctDao.getByMaDH(ma));
             request.getRequestDispatcher("admin-donhang-view.jsp").forward(request, response);
			break;
		case "add":
			request.setAttribute("listKH", new KhachHangDao().findAll());
			request.setAttribute("listNV", new NhanVienDao().findAll());
			request.setAttribute("listSP", new SanPhamDao().findAll());
			request.getRequestDispatcher("admin-donhang-form.jsp").forward(request, response);
			break;
		case "delete":
            dhDao.delete(request.getParameter("maDH"));
            response.sendRedirect("admin-donhang");
            break;
		case "edit":
		    String id = request.getParameter("maDH");
		    request.setAttribute("dh", dhDao.findById(id));
		    request.setAttribute("listKH", new KhachHangDao().findAll());
            request.setAttribute("listNV", new NhanVienDao().findAll());
            request.setAttribute("listSP", new SanPhamDao().findAll());
		    request.getRequestDispatcher("admin-donhang-form.jsp").forward(request, response);
		    break;
		case "search":
		    String key = request.getParameter("key");
		    if (key == null || key.trim().isEmpty()) {
		        request.setAttribute("listDH", dhDao.findAll());
		    } else {
		        request.setAttribute("listDH", dhDao.search(key));
		    }
		    request.getRequestDispatcher("admin-donhang.jsp").forward(request, response);
		    break;
		default:
			request.setAttribute("listDH", dhDao.findAll());
            request.getRequestDispatcher("admin-donhang.jsp").forward(request, response);
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
	    String maDH = request.getParameter("maDH");

	    String[] sp = request.getParameterValues("maSP");
	    String[] sl = request.getParameterValues("soLuong");
	    String[] gia = request.getParameterValues("donGia");

	    int tong = 0;

	 
	 DonHang old1 = new DonHangDao().findById(maDH);

	 if ("update".equals(action) && (sp == null || sp.length == 0)) {
	     tong = old1.getTongTien();
	 }
	 else {
	     if (sp != null) {
	         for (int i = 0; i < sp.length; i++) {
	             int q = Integer.parseInt(sl[i]);
	             int p = Integer.parseInt(gia[i]);
	             tong += q * p;
	         }
	     }
	 }


	    // Giữ nguyên ngày tạo khi update
	    Date ngayTao;
	    DonHang old = new DonHangDao().findById(maDH);
	    if (old != null) {
	        ngayTao = old.getNgayTao();
	    } else {
	        ngayTao = new Date();
	    }

	    String trangThai = request.getParameter("trangThai");
	    if (trangThai == null || trangThai.trim().isEmpty()) {
	        trangThai = "Đang xử lý";
	    }

	    DonHang dh = new DonHang(
	        maDH,
	        new KhachHangDao().findById(request.getParameter("maKH")),
	        new NhanVienDao().findById(request.getParameter("maNV")),
	        request.getParameter("diaChi"),
	        tong,
	        ngayTao,
	        trangThai
	    );

	    DonHangDao dhDao = new DonHangDao();
	    ChiTietDonHangDao ctDao = new ChiTietDonHangDao();

	    if ("insert".equals(action)) {
	        dhDao.insert(dh);
	    } else if ("update".equals(action)) {
	        dhDao.update(dh);
	        ctDao.deleteByMaDH(maDH);
	    }

	    // Ghi chi tiết
	    if (sp != null) {
	        for (int i = 0; i < sp.length; i++) {
	            int q = Integer.parseInt(sl[i]);
	            int p = Integer.parseInt(gia[i]);
	            ChiTietDonHang ct = new ChiTietDonHang(maDH, sp[i], p, q, q * p);
	            ctDao.insert(ct);
	        }
	    }

	    response.sendRedirect("admin-donhang");
	}
}