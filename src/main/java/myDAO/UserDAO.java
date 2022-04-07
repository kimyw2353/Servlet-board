package myDAO;

import dbUtil.DBUtils;
import domain.Paging;
import domain.UsersVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DBUtils {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    int result;


    //로그인 - id, password 일치 체크
    public int selectUserById(String inputId, String inputPw){
        String SQL = "SELECT * FROM USERS WHERE email=?";
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, inputId);
            rs = pstmt.executeQuery();

            if(rs.next()){ //아이디 확인
                if(inputPw.equals(rs.getString("PASSWORD"))){
                    return 1; //비밀번호 일치
                }else {
                    return 0; //비밀번호 불일치
                }
            }return -1; //아이디 없음
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(rs,pstmt,conn);
        }
        return -2; //DB오류
    }

    //아이디 중복체크 - email이 존재하는지 체크
    public int selectUserEmail(String email){
        String SQL = "SELECT email FROM USERS WHERE email=?";
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return 0; //이미 존재
            }else{
                return 1; //사용가능
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(rs, pstmt, conn);
        }
        return -1;
    }

    public int insertUserData(UsersVO vo) {
        String SQL = "INSERT INTO USERS VALUES(DEFAULT,?,?,?,DEFAULT,DEFAULT)";
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, vo.getEmail());
            pstmt.setString(2, vo.getPassword());
            pstmt.setString(3, vo.getName());

            result = pstmt.executeUpdate();

            //insert된 데이터 갯수 반환
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(rs, pstmt,conn);
        }
        return -1;
    }

    //해당id 회원정보 불러오기

    //회원정보 수정

    //모든 회원정보 불러오기 - ArrayList로 UsersVO
    public List<UsersVO> selectAllUser(Paging paging){
        int startSeq = paging.getStartSeq();
        int pageSize = paging.getPageSize();

        String SQL = "SELECT * FROM users LIMIT ?, ?";
        List<UsersVO> userList = new ArrayList<>();
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, startSeq);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()){
                UsersVO vo = new UsersVO();
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
        String SQL = "select count(*) from users";
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, conn);
        }
        return total;
    }
}
