package domain;

import java.sql.Date;

public class UsersVO {

    private int idx; //회원번호
    private String email;
    private String password; //비밀번호
    private String name; //이름
    private Date create_at;
    private Date update_at;

    public UsersVO(){

    }

    public UsersVO(int idx, String password, String name, String email, Date create_at, Date update_at) {
        this.idx = idx;
        this.password = password;
        this.email = email;
        this.name = name;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public UsersVO(String userEmail, String userPw, String name) {
        this.email = userEmail;
        this.password = userPw;
        this.name = name;
    }

    public int getIdx() {
        return idx;
    }

    public void setId(String id) {
        this.idx = idx;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "UsersVO{" +
                "id='" + idx + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }




}
