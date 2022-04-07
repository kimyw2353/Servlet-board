package postController;

import domain.Paging;
import domain.PostsVO;
import domain.UsersVO;
import myDAO.PostDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/boardList.do")
public class BoardListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PostDAO postDAO = new PostDAO();
        int page;
        if(request.getParameter("page")!=null){
            page = Integer.parseInt(request.getParameter("page"));
        }else {
            page = 1;
        }

        Paging paging = new Paging();
        paging.setPageNo(page);
        paging.setPageSize(10);
        paging.setStartSeq(1);
        paging.setTotalCount(postDAO.getTotalCount());

        List<PostsVO> postList = postDAO.selectAllPost(paging);

        request.getParameter("postList", postList);
        request.getParameter("paging", paging);

        String path = "posts/boardList.jsp";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}