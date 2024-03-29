package userController;

import domain.UsersVO;
import myDAO.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/join.do")
public class JoinController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HttpServletResponse 를 사용하면 sendRedirect() 메소드를 이용하여 지정한 경로로 이동시킬 수 있지만
        // 브라우저에 Response 후 브라우저에서 받아온 요청경로로 재요청을 하는 방식이라 두번의 트랜잭션이 발생한다.
        // 서버측에서는 최초에 받은 요청중에 처리한 내용을 Redirect 된 요청 안에서 공유할 수 없다

        //request.getRequestDispatcher("/users/join.jsp").forward(request, response);

        String path = "users/join.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userEmail = null;
        String userPw = null;
        String name = null;

        if(request.getParameter("userEmail")!=null){
            userEmail = (String)request.getParameter("userEmail");
        }
        if(request.getParameter("userpw")!=null){
            userPw = (String)request.getParameter("userpw");
        }
        if(request.getParameter("name")!=null){
            name = (String)request.getParameter("name");
        }

        UsersVO vo = new UsersVO(userEmail, userPw, name);
        UserDAO userDAO = new UserDAO();

        //for(int i=0;i<243;i++){
        int result = userDAO.insertUserData(vo);
        //}

        String msg=(result>0)?"회원가입 성공":"회원가입 실패";
        String loc=(result>0)?"login.do":"javascript:history.back()";

        request.setAttribute("msg",msg);
        request.setAttribute("loc",loc);

        String path="/msg/msg.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }
}
