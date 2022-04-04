package userController;

import domain.UsersVO;
import myDAO.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/userList.do")
public class UserListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("loginUserId")==null){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.println("<script>alert('로그인 후 이용 가능합니다.'); window.history.back();</script>");
        }
        UserDAO userDAO = new UserDAO();
        UsersVO usersVO = new UsersVO();
        List<UsersVO> userList = userDAO.selectAllUserList();
        request.setAttribute("userList", userList);

        String path = "users/userList.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
