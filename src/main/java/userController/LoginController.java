package userController;

import domain.UsersVO;
import myDAO.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login.do")
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
        String inputEmail = null;
        String inputPw = null;
        UsersVO vo = null;
        HttpSession session = request.getSession();

        if(request.getParameter("inputEmail")!=null){
            inputEmail = (String)request.getParameter("inputEmail");
        }
        if(request.getParameter("inputPw")!=null){
            inputPw = (String)request.getParameter("inputPw");
        }
        UserDAO userDAO = new UserDAO();
        String msg = "";
        String loc = "";
        int result = userDAO.selectUserByEmail(inputEmail, inputPw);

        if(result==1){ //로그인 성공
            vo = new UsersVO();
            vo = userDAO.selectUserByIdx(inputEmail);
            session.setAttribute("loginUser", vo);
            session.setAttribute("loginUserIdx", vo.getIdx());
            String loginUserName = vo.getName();
            msg = loginUserName+"님 환영합니다.";
            loc = "main.do";
        }else if(result==-1){
            msg = "존재하지 않는 아이디입니다.";
            loc = "javascript:history.back()";
        }else if(result==0){
            msg = "비밀번호가 일치하지 않습니다.";
            loc = "javascript:history.back()";
        }

        request.setAttribute("msg", msg);
        request.setAttribute("loc", loc);

        String path = "/msg/msg.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request,response);
    }
}
