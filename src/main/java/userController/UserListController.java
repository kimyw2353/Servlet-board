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
        int pageSize = 5;
        if (request.getParameter("page") != null){
            page = Integer.parseInt(request.getParameter("page"));
        }

        Paging paging = new Paging();
        paging.setPageNo(page);
        paging.setPageSize(pageSize);
        paging.setTotalCount(userDAO.getTotalCount());
        System.out.println("totalCount() :"+userDAO.getTotalCount());

        List<UsersVO> userList = userDAO.selectAllUser(paging);

        System.out.println("paging.getPageNo : " + paging.getPageNo());

        request.setAttribute("userList", userList);
        request.setAttribute("paging", paging);

        System.out.println("paging ToString : " + paging.toString());

        String path = "users/userList.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);

    }
}
