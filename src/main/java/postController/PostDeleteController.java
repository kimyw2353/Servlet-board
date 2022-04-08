package postController;

import myDAO.PostDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/postDelete.do")
public class PostDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idx = Integer.parseInt(request.getParameter("idx"));

        PostDAO postDAO = new PostDAO();
        int result = postDAO.deletePostByIdx(idx);
        String msg =(result>0)?"삭제 성공":"삭제 실패";
        String loc = (result>0)?"/postList.do":"javascript:history.back()";

        request.setAttribute("msg", msg);
        request.setAttribute("loc", loc);

        String path = "/msg/msg.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
