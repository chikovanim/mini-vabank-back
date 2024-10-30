package ge.bog.vabank.demo.minivabankback.ws;

import ge.bog.vabank.demo.minivabankback.model.AuthResponse;
import ge.bog.vabank.demo.minivabankback.model.ClientModel;
import ge.bog.vabank.demo.minivabankback.model.UserModel;
import ge.bog.vabank.demo.minivabankback.service.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("vabank-api")
public class ServiceController {

    private final Service clientService;

    public ServiceController(Service clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<ClientModel> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/clients/{clientKey}")
    public ClientModel getClientDetails(@PathVariable Long clientKey) {
        return clientService.getClientModel(clientKey);
    }

    @PostMapping("/authorize")
    public AuthResponse authorizeUser(@RequestParam String username, @RequestParam String password) {
        return clientService.authorizeUser(username, password);
    }

    @PostMapping("/register-user")
    public void registerUser(@RequestBody UserModel userModel) {
        System.out.println(userModel.getUsername());
        System.out.println(userModel.getPassword());

        clientService.registerUser(userModel);
    }

    @DeleteMapping("/clients/{clientKey}")
    public void registerUser(@PathVariable Long clientKey) {
        System.out.println("deleting client");

        clientService.removeClient(clientKey);
    }

    @PostMapping("/clients")
    public Long addClient(@RequestBody ClientModel clientModel) {
        return clientService.addClient(clientModel);
    }
}
