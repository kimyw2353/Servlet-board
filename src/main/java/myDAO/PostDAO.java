package myDAO;

import dbUtil.DBUtils;
import domain.Paging;
import domain.PostsVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO extends DBUtils {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    int result;

    /*글 등록*/
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

    /*해당 글 정보 불러오기*/
    public PostsVO selectPostByIdx(int idx){
        String SQL = "SELECT p.idx, p.title, p.content, u.name, p.create_at, p.update_at \n" +
                "FROM users u JOIN posts p  \n" +
                "ON u.idx = p.user_idx where p.idx = ?";
        System.out.println(SQL);
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, idx);
            rs = pstmt.executeQuery();
            if(rs.next()){
                PostsVO vo = new PostsVO();
                vo.setIdx(rs.getInt(1));
                vo.setTitle(rs.getString(2));
                vo.setContent(rs.getString(3));
                vo.setName(rs.getString(4));
                vo.setCreate_at(rs.getDate(5));
                vo.setUpdate_at(rs.getDate(6));
                return vo;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(rs, pstmt, conn);
        }
        return null;
    }
    
    /*게시물 수정*/
    public int editPost(String title, String content, int idx){
        String SQL = "UPDATE posts SET title=?, content=?, update_at=NOW() WHERE idx = ?";
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setInt(3, idx);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rs, pstmt, conn);
        }
        return result;
    }
    
    /*모든 글 List 로 불러오기*/
    public List<PostsVO> selectAllPost(Paging paging) {
        int startSeq = paging.getStartSeq();
        int pageSize = paging.getPageSize();

        //String SQL = "SELECT * FROM posts ORDER BY update_at desc LIMIT ?, ?";
        String SQL = "SELECT p.idx, p.title, u.name, p.create_at, p.update_at \n" +
                "FROM users u JOIN posts p  \n" +
                "ON u.idx = p.user_idx \n" +
                "LIMIT ?,?";
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
                vo.setName(rs.getString("name"));
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
    
    /*게시물 총 개수 구하기*/
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
