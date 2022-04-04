package userController;

import com.sun.org.slf4j.internal.LoggerFactory;
import domain.UsersVO;
import users.DAO.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/login.do", value = "/login.do")
public class
LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "users/login.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String inputId = null;
        String inputPw = null;
        UsersVO usersVO;
        HttpSession session = request.getSession();

        if(request.getParameter("inputId")!=null){
            inputId = (String)request.getParameter("inputId");
        }
        if(request.getParameter("inputPw")!=null){
            inputPw = (String)request.getParameter("inputPw");
        }
        UserDAO userDAO = new UserDAO();
        String msg = "";
        String loc = "";
        int result = userDAO.selectUserById(inputId, inputPw);
        if(result==-1){ //아이디 없음
            msg = "존재하지 않는 아이디입니다.";
            loc = "javascript:history.back()";
        }else if(result==0){ //비밀번호 불일치치
            msg = "비밀번호가 일치하지 않습니다.";
            loc = "javascript:history.back()";
        }else if(result==1){ //로그인 성공
            session.setAttribute("loginUserId", inputId);
            msg = (String)session.getAttribute("loginUserId")+"님 환영합니다.";
            loc = "main";
        }

        request.setAttribute("msg", msg);
        request.setAttribute("loc", loc);

        String path = "/msg/msg.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request,response);
    }
}
