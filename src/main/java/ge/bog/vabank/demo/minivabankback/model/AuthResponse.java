package ge.bog.vabank.demo.minivabankback.model;

import lombok.Data;

@Data
public class AuthResponse {

    private boolean success;
    private UserModel userDetails;

    public AuthResponse(boolean status, UserModel user) {
        this.success = status;
        this.userDetails = user;
    }
}
