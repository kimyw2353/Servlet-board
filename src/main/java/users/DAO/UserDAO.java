package users.DAO;

import dbUtil.DBUtils;

import java.sql.*;

public class UserDAO {
    private Connection con = DBUtils.getConnection();

    //로그인 - id, password 일치 체크

    //아이디 중복체크 - id가 존재하는지 체크

    public int insertUserData(String id, String email, String name, String password) {
        String SQL = "INSERT INTO USERS VALUES(?,?,?,?,DEFAULT,DEFAULT)";
        try {
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, id);
            pstmt.setString(2, email);
            pstmt.setString(3, name);
            pstmt.setString(4, password);

            //insert된 데이터 갯수 반환
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    //해당id 회원정보 불러오기

    //회원정보 수정

    //모든 회원정보 불러오기 - ArrayList로 UsersDTO
}
