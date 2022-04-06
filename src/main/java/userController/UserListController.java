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
        int page;
        System.out.println("getParameter page : "+request.getParameter("page"));
        if (request.getParameter("page") != null){
            page = Integer.parseInt(request.getParameter("page"));
        }else {
            page = 1;
        }
        //System.out.println("int page : "+page );

        Paging paging = new Paging();
        paging.setPageNo(page);

        //System.out.println("paging.getPageNo : " + paging.getPageNo());

        paging.setPageSize(10);
        paging.setTotalCount(userDAO.getTotalCount());

        //System.out.println("totalCount() :"+userDAO.getTotalCount());

        List<UsersVO> userList = userDAO.selectAllUser(paging);


        request.setAttribute("userList", userList);
        request.setAttribute("paging", paging);

        System.out.println("paging ToString : " + paging.toString());

        String path = "users/userList.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);

    }
}
