package postController;

import domain.PostsVO;
import myDAO.PostDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/postEdit.do")
public class PostEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idx = 0;
        idx = Integer.parseInt(request.getParameter("idx"));
        if(idx == 0){
            return;
        }
        PostDAO postDAO = new PostDAO();
        postDAO.editPost(idx);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
