package postController;

import domain.PostsVO;
import domain.UsersVO;
import myDAO.PostDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/write.do")
public class PostWriteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userIdx = session.getId();
        UsersVO vo = (UsersVO) session.getAttribute("loginUser");

        request.setAttribute("loginUser", vo);
        String path = "posts/postWrite.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int user_idx = Integer.parseInt(request.getParameter("user_idx"));

        if(title == null || title.isEmpty()){
            return;
        }else if(content == null||content.isEmpty()){
            return;
        }
        PostDAO postDAO = new PostDAO();
        PostsVO vo = new PostsVO();
        vo.setTitle(title);
        vo.setContent(content);
        vo.setUser_id(user_idx);
        int result = postDAO.insertPostData(vo);

        String msg = (result>0)?"업로드 완료":"업로드 실패";
        String loc = (result>0)?"boardList.do?page=1":"javascript:history.back()";

        request.setAttribute("msg", msg);
        request.setAttribute("loc", loc);

        String path = "/msg/msg.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }
}
