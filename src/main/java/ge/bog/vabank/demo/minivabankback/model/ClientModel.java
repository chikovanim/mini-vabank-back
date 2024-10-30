package ge.bog.vabank.demo.minivabankback.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientModel {

    private Long clientKey;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String birthDate;
}
