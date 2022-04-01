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

    //아이디 중복체크 - id가 존재하는지 체크
    public int selectUserId(String id){
        String SQL = "SELECT * FROM USERS WHERE ID=?";
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return 0; //사용불가능
            }else{
                return 1; //사용가능
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnection(rs, pstmt,conn);
        }
        return -1;
    }

    public int insertUserData(UsersVO vo) {
        String SQL = "INSERT INTO USERS VALUES(?,?,?,?,DEFAULT,DEFAULT)";
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getEmail());
            pstmt.setString(3, vo.getName());
            pstmt.setString(4, vo.getPassword());

            result = pstmt.executeUpdate();

            //insert된 데이터 갯수 반환
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection(rs, pstmt,conn);
        }
        return -1;
    }

    //해당id 회원정보 불러오기

    //회원정보 수정

    //모든 회원정보 불러오기 - ArrayList로 UsersDTO
}
