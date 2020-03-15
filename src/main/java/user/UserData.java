package user;

import lombok.Data;

@Data
public class UserData {

    public Integer id;
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public Integer userStatus;
}
