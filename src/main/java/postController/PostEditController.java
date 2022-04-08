package postController;

import domain.PostsVO;
import javafx.geometry.Pos;
import myDAO.PostDAO;
import myDAO.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/postEdit.do")
public class PostEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idx = 0;
        try{
            idx = Integer.parseInt(request.getParameter("idx"));
        }catch (Exception e){
            e.printStackTrace();
        }
        if(idx==0){
            return;
        }

        PostDAO postDAO = new PostDAO();
        PostsVO vo = postDAO.selectPostByIdx(idx);
        request.setAttribute("postView", vo);

        String path = "/posts/postEdit.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int idx = Integer.parseInt(request.getParameter("idx"));

        if(title==null||content==null){
            return;
        }
        System.out.println(title + "/"+content+"/"+idx);
        PostDAO postDAO = new PostDAO();
        int result = postDAO.editPost(title, content, idx);

        String msg = (result>0)?"수정 완료":"수정 실패";
        String loc = (result>0)?"/postView.do?idx="+idx:"javascript:history.back()";

        request.setAttribute("msg", msg);
        request.setAttribute("loc", loc);

        String path = "/msg/msg.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request,response);

    }
}
