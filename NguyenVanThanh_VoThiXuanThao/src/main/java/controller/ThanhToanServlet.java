package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ChiTietDonHangDao;
import dao.DonHangDao;
import dao.GioHangChiTietDao;
import dao.GioHangDao;
import dao.ThanhToanDao;
import model.ChiTietDonHang;
import model.DonHang;
import model.GiaoHang;
import model.GioHang;
import model.GioHangChiTiet;
import model.KhachHang;
import model.ThanhToan;

/**
 * Servlet implementation class ThanhToanServlet
 */
@WebServlet("/thanhtoan")
public class ThanhToanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanhToanServlet() {
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
		HttpSession session = request.getSession();
		KhachHang kh = (KhachHang) session.getAttribute("user");
		
		if(kh ==null) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		String pttt= request.getParameter("pttt");
		if(pttt.equals("BANK")) {
			GioHangDao ghDao= new GioHangDao();
			GioHangChiTietDao ctDao= new GioHangChiTietDao();
			GioHang gh= ghDao.getByMaKH(kh.getMaKH());
			List<GioHangChiTiet> list= ctDao.getByMaGH(gh.getMaGH());
			int tong=0;
			for(GioHangChiTiet ct : list) {
				tong +=ct.getSanPham().getGiaBan()*ct.getSoLuong();
			}
			request.setAttribute("tong", tong);
			request.getRequestDispatcher("qr.jsp").forward(request, response);
			return;
		}
		taoDonHang(kh, pttt, request, response);
	}		

	void taoDonHang(KhachHang kh, String pttt, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GioHangDao ghDao= new  GioHangDao();
		GioHangChiTietDao ctDao= new GioHangChiTietDao();
		DonHangDao dhDao= new DonHangDao();
		ChiTietDonHangDao ctdhDao= new ChiTietDonHangDao();
		ThanhToanDao ttDao= new ThanhToanDao();
		
		GioHang gh= ghDao.getByMaKH(kh.getMaKH());
		List<GioHangChiTiet> list = ctDao.getByMaGH(gh.getMaGH());
		
		int tong=0;
		for(GioHangChiTiet ct : list) {
			tong += ct.getSanPham().getGiaBan()*ct.getSoLuong();
		}
		
		//tao ma don
		String maDH= "DH" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		DonHang dh= new DonHang();
		dh.setMaDH(maDH);
		dh.setKhachHang(kh);
		dh.setNhanVien(null);
		dh.setTongTien(tong);
		dh.setDiaChiGiaoHang(kh.getDiaChi());
		dh.setNgayTao(new Date());
		dh.setTrangThai("cho xu ly");
		dhDao.insert(dh);
		//chi tiet don hang
		for(GioHangChiTiet ct : list) {
			ChiTietDonHang ctDH= new ChiTietDonHang(maDH, ct.getSanPham().getMaSP(), ct.getSanPham().getGiaBan(), ct.getSoLuong(), ct.getSanPham().getGiaBan()* ct.getSoLuong());
			ctdhDao.insert(ctDH);
		}
		//thanh toan cod
		String maTT= "TT"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		ThanhToan tt= new ThanhToan();
		tt.setMaTT(maTT);
		tt.setDonHang(dh);
		tt.setNhanVien(null);
		tt.setSoTien(tong);
		tt.setNgayThanhToan(new Date());
		tt.setHinhThucTT(pttt);
		tt.setTrangThai("Thanh cong");
		ttDao.insert(tt);
		//xoa gio hang
		for(GioHangChiTiet ct : list) {
			ctDao.delete(ct.getGioHang().getMaGH(), ct.getSanPham().getMaSP());
		}
		
		request.setAttribute("maDH", maDH);
		request.setAttribute("pttt", pttt );
		request.getRequestDispatcher("user-thanhtoan.jsp").forward(request, response);
	}

}
