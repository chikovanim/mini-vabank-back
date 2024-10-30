package ge.bog.vabank.demo.minivabankback.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserModel {

    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String position;
    private String role;
}
