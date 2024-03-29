package userController;

import org.hibernate.dialect.lock.SelectLockingStrategy;

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
        System.out.println(session.getAttribute("loginUser")+"<-login Us");
        if(session.getAttribute("loginUser")!=null){
            session.removeAttribute("loginUser");
            msg="로그아웃되었습니다.";
            loc = "main.do";

            request.setAttribute("msg", msg);
            request.setAttribute("loc", loc);

            String path = "/msg/msg.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        }else{
            response.sendRedirect("/main.do");
        }


    }
}
