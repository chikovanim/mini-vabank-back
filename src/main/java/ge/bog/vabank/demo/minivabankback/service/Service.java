package ge.bog.vabank.demo.minivabankback.service;

import ge.bog.vabank.demo.minivabankback.model.AuthResponse;
import ge.bog.vabank.demo.minivabankback.model.ClientModel;
import ge.bog.vabank.demo.minivabankback.model.UserModel;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private final FakeRepository fakeRepository;

    public Service(FakeRepository fakeRepository) {
        this.fakeRepository = fakeRepository;
    }

    public List<ClientModel> getClients() {
        return fakeRepository.getFakeClients();
    }

    public AuthResponse authorizeUser(String username, String password) {
        List<UserModel> users = fakeRepository.getFakeUsers();

        UserModel authorizedUser = null;

        for (UserModel user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                authorizedUser = user;
            }
        }
        return new AuthResponse(authorizedUser != null, authorizedUser);
    }

    public ClientModel getClientModel(Long clientKey) {
        List<ClientModel> clients = fakeRepository.getFakeClients();
        for (ClientModel client : clients) {
            if (client.getClientKey().equals(clientKey)) {
                return client;
            }
        }
        return null;
    }

    public void registerUser(UserModel userModel) {
        fakeRepository.addUser(userModel);
    }

    public void removeClient(Long clientKey) {
        fakeRepository.removeClient(clientKey);
    }

    public Long addClient(ClientModel clientModel) {
        return fakeRepository.addClient(clientModel);
    }
}
