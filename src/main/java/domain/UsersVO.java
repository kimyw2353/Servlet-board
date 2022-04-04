package domain;

import java.sql.Date;

public class UsersVO {

    private String id; //회원번호
    private String password; //비밀번호
    private String name; //이름
    private String email;
    private Date create_at;
    private Date update_at;

    public UsersVO(String id, String password, String name, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public UsersVO(String id, String password, String name, String email, Date create_at, Date update_at) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.create_at = create_at;
        this.update_at = update_at;
    }


    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = String.valueOf(id);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

}
