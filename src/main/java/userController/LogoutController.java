package userController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/logout.do")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "";
        String loc = "";

        HttpSession session = request.getSession();
        if(session.getAttribute("loginUserId")!=null){
            session.removeAttribute("loginUserId");
            msg="로그아웃되었습니다.";
            loc = "main";
        }

        request.setAttribute("msg", msg);
        request.setAttribute("loc", loc);

        String path = "/msg/msg.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }
}
