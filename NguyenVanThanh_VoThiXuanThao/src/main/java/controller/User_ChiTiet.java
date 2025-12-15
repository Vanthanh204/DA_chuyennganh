package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.SanPhamDao;
import model.SanPham;

@WebServlet("/chitiet")
public class User_ChiTiet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public User_ChiTiet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String masp = request.getParameter("masp");

        if (masp == null) {
            response.sendRedirect("userservlet");
            return;
        }

        SanPhamDao spDao = new SanPhamDao();
        SanPham sp = spDao.findById(masp);

        if (sp == null) {
            request.setAttribute("msg", "Không tìm thấy sản phẩm!");
            return;
        }

        request.setAttribute("sp", sp);
        request.getRequestDispatcher("user-chitiet.jsp").forward(request, response);
    }
}
