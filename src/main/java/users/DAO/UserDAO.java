package users.DAO;

import dbUtil.DBUtils;
import domain.UsersVO;
import org.hibernate.annotations.common.util.impl.LoggerFactory;

import java.sql.*;

public class UserDAO extends DBUtils {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    int result;

    //로그인 - id, password 일치 체크
    public int selectUserById(String inputId, String inputPw){
        String SQL = "SELECT * FROM USERS WHERE ID=?";
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

    //아이디 중복체크 - id가 존재하는지 체크
    public int selectUserId(String id){
        String SQL = "SELECT ID FROM USERS WHERE ID=?";
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return 0; //이미 존재
            }else{
                return 1; //사용가능
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(rs, pstmt,conn);
        }
        return -1;
    }

    public int insertUserData(UsersVO vo) {
        String SQL = "INSERT INTO USERS VALUES(?,?,?,?,DEFAULT,DEFAULT)";
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getPassword());
            pstmt.setString(3, vo.getName());
            pstmt.setString(4, vo.getEmail());

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

    //모든 회원정보 불러오기 - ArrayList로 UsersDTO
}
