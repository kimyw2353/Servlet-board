package myDAO;

import dbUtil.DBUtils;
import domain.Paging;
import domain.PostsVO;
import domain.UsersVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDAO extends DBUtils {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    int result;

    public int insertPostData(PostsVO vo){
        String SQL = "INSERT INTO POSTS VALUES(?,?,?,?,DEFAULT,DEFAULT)";
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, "id");
            pstmt.setString(2, "title");
            pstmt.setString(3, "content");
            pstmt.setString(4, "user_id");

            result = pstmt.executeUpdate();
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(rs, pstmt, conn);
        }
        return -1;
    }

    public List<PostsVO> selectAllPost(Paging paging) {
        int startSeq = paging.getStartSeq();
        int pageSize = paging.getPageSize();

        String SQL = "SELECT * FROM posts LIMIT ?, ?";
        List<UsersVO> userList = new ArrayList<>();
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, startSeq);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()){
                PostsVO vo = new PostsVO();
                vo.setIdx(rs.getInt("idx"));
                vo.setEmail(rs.getString("email"));
                vo.setPassword(rs.getString("password"));
                vo.setName(rs.getString("name"));
                vo.setCreate_at(rs.getDate("create_at"));
                vo.setUpdate_at(rs.getDate("update_at"));
                userList.add(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(rs, pstmt, conn);
        }
        return userList;
    }

    public int getTotalCount() {
        int total = 0;
        String SQL = "SELECT count(*) FROM posts";
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            if(rs.next()){
                total = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(rs, pstmt, conn);
        }
        return total;
    }
}
