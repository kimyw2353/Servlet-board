package userController;

import domain.Paging;
import domain.UsersVO;
import myDAO.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/userList.do")
public class UserListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();

        int page = 1;
        if (request.getParameter("page") != null){
            page = Integer.parseInt(request.getParameter("page"));
        }

        Paging paging = new Paging();
        paging.setPage(page);
        paging.setTotalCount(userDAO.getTotalCount());

        List<UsersVO> userList = userDAO.selectAllUser(paging);

        System.out.println("paging.getPagNUM : " + paging.getPage());
        request.setAttribute("userList", userList);
        request.setAttribute("userPaging", paging);

        String path = "users/userList.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
