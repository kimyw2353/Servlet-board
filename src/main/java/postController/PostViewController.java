package postController;

import domain.PostsVO;
import myDAO.PostDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/postView.do")
public class PostViewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg;
        String loc;
        HttpSession session = request.getSession();
        int idx = Integer.parseInt(request.getParameter("idx")); //글번호
        int user_idx;
        int loginUserIdx = (int) session.getAttribute("loginUserIdx"); //접속중인 유저
        boolean userCheck = false;

        PostDAO postDAO = new PostDAO();
        PostsVO vo = postDAO.selectPostByIdx(idx); //vo에 담아줌
        user_idx = vo.getUser_idx();

        if(vo!=null){
            request.setAttribute("postView", vo);
            request.setAttribute("loginUserIdx", loginUserIdx);
            if(loginUserIdx==user_idx){ //로그인 유저와 작성자가 일치하다면
                userCheck = true;
            }
            request.setAttribute("userCheck", userCheck);
        }else{
            return;
        }

        String path = "posts/postView.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
