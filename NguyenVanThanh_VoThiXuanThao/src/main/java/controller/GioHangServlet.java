package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GioHangChiTietDao;
import dao.GioHangDao;
import model.GioHang;
import model.GioHangChiTiet;
import model.KhachHang;

@WebServlet("/giohang")
public class GioHangServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	response.setContentType("text/html; charset=UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	
        String action = request.getParameter("action");
        String maSP = request.getParameter("maSP");

        // -------------------------
        // 0. KIỂM TRA ĐĂNG NHẬP
        // -------------------------
        KhachHang kh = (KhachHang) request.getSession().getAttribute("user");
        if (kh == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        GioHangDao ghDao = new GioHangDao();
        GioHangChiTietDao ctDao = new GioHangChiTietDao();

        //tao gio hang
        GioHang gh = ghDao.getByMaKH(kh.getMaKH());
        if (gh == null) {
            gh = ghDao.createGH(kh);
        }

        String maGH = gh.getMaGH();

        if ("add".equals(action) && maSP != null) {
            ctDao.add(maGH, maSP);
            response.sendRedirect("giohang");
            return;
        }

        if ("plus".equals(action) && maSP != null) {
            GioHangChiTiet item = ctDao.find(maGH, maSP);
            ctDao.updateSoLuong(maGH, maSP, item.getSoLuong() + 1);
            response.sendRedirect("giohang");
            return;
        }

        if ("minus".equals(action) && maSP != null) {
            GioHangChiTiet item = ctDao.find(maGH, maSP);
            if (item != null) {
                if(item.getSoLuong() ==1) {
                	ctDao.delete(maGH, maSP);
                }else {
                	ctDao.updateSoLuong(maGH, maSP, item.getSoLuong() -1);
                }
            }
            response.sendRedirect("giohang");
            return;	
        }

        if ("delete".equals(action) && maSP != null) {
        	System.out.println("ACTION = " + action + " - maSP = " + maSP);

            ctDao.delete(maGH, maSP);
            response.sendRedirect("giohang");
            return;
        }

        //lay gio hang
        List<GioHangChiTiet> list = ctDao.getByMaGH(maGH);

        int tong = 0;
        if (list != null) {
            for (GioHangChiTiet ct : list) {
                tong += ct.getSanPham().getGiaBan() * ct.getSoLuong();
            }
        }

        request.setAttribute("list", list);
        request.setAttribute("tong", tong);
        request.setAttribute("maGH", maGH);

        request.getRequestDispatcher("user-giohang.jsp").forward(request, response);
    }
}
