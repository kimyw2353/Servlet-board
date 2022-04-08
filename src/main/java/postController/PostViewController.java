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
        int user_idx = Integer.parseInt(request.getParameter("user_idx"));//작성자
        int loginUserIdx = (int) session.getAttribute("loginUserIdx"); //접속중인 유저

        PostDAO postDAO = new PostDAO();
        PostsVO vo = postDAO.selectPostByIdx(idx); //vo에 담아줌
        if(vo!=null){
            request.setAttribute("postView", vo);
            request.setAttribute("loginUserIdx", loginUserIdx);
            request.setAttribute("user_idx", user_idx);
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
