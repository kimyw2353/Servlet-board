package userController;

import myDAO.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/checkId.do", value = "/checkId")
public class CheckIdController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String userId = request.getParameter("userid");
        response.getWriter().write(checkUserId(userId));
    }

    private int checkUserId(String userId) {
        UserDAO userDAO = new UserDAO();
        return userDAO.selectUserId(userId);
    }
}
