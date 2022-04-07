package myDAO;

import dbUtil.DBUtils;
import domain.Paging;
import domain.PostsVO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDAO extends DBUtils {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    int result;

    /*public PostsVO selectPostByIdx(PostsVO vo){
        String SQL = "SELECT * FROM POSTS WHERE = ?";
        try{
            conn = getConnection();
            conn.prepareStatement(SQL);
            pstmt.setString(1, vo.getIdx());
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    public int insertPostData(PostsVO vo){
        String SQL = "INSERT INTO POSTS VALUES(DEFAULT,?,?,?,DEFAULT,DEFAULT)";
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getContent());
            pstmt.setInt(3, vo.getUser_idx());

            result = pstmt.executeUpdate();
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(rs, pstmt, conn);
        }
        return -1;
    }

    public int editPost(int idx){
        String SQL = "UPDATE posts SET title=?, content=?, update_at=? WHERE idx = ?";
    }

    /* ---- 현재 시간 가져오는 함수
    public Date getDate(){
        String SQL = "SELECT SYSDATE FROM BBS";
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getDate(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(rs, pstmt, conn);
        }
        return null;
    }----*/

    public List<PostsVO> selectAllPost(Paging paging) {
        int startSeq = paging.getStartSeq();
        int pageSize = paging.getPageSize();

        String SQL = "SELECT * FROM posts ORDER BY update_at desc LIMIT ?, ?";
        List<PostsVO> postList = new ArrayList<>();
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, startSeq);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()){
                PostsVO vo = new PostsVO();
                vo.setIdx(rs.getInt("idx"));
                vo.setTitle(rs.getString("title"));
                vo.setUser_id(rs.getInt("user_idx"));
                vo.setCreate_at(rs.getDate("create_at"));
                vo.setUpdate_at(rs.getDate("update_at"));
                postList.add(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(rs, pstmt, conn);
        }
        return postList;
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
