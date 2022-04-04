package myDAO;

import dbUtil.DBUtils;
import domain.PostsVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
