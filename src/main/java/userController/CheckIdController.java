package userController;

import myDAO.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/checkId.do")
public class CheckIdController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String userEmail = request.getParameter("userEmail");
        response.getWriter().write(checkUserEmail(userEmail)+"");
    }

    private int checkUserEmail(String userEmail) {
        UserDAO userDAO = new UserDAO();
        return userDAO.selectUserEmail(userEmail);
    }
}
