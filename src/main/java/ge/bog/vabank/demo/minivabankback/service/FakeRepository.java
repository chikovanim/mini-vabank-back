package ge.bog.vabank.demo.minivabankback.service;

import ge.bog.vabank.demo.minivabankback.model.ClientModel;
import ge.bog.vabank.demo.minivabankback.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FakeRepository {

    List<UserModel> users = new ArrayList<>();
    List<ClientModel> clients = new ArrayList<>();
    public List<ClientModel> getFakeClients() {
        if (clients.isEmpty()) {
            addMockClients();
        }
        return clients;
    }

    public List<UserModel> getFakeUsers() {
        if (users.isEmpty()) {
            addMockUsers();
        }
        return users;
    }

    public void addUser(UserModel userModel) {
        users.add(userModel);
    }

    public void removeClient(Long clientKey) {
        clients = clients.stream().filter(client -> !Objects.equals(client.getClientKey(), clientKey)).collect(Collectors.toList());
    }

    public Long addClient(ClientModel clientModel) {
        Long clientKey = (long) clients.size() + 1;
        clientModel.setClientKey(clientKey);
        clients.add(clientModel);
        return clientKey;
    }

    public void addMockClients() {
        clients.add(new ClientModel(1L, "Davit", "Chirkovani", "johndoe", "john.doe@example.com",
                "123-456-7890", "123 Elm St", "Springfield", "USA", "12345", "1990-01-01"));
        clients.add(new ClientModel(2L, "Jane", "Smith", "janesmith", "jane.smith@example.com",
                "987-654-3210", "456 Oak St", "Springfield", "USA", "12345", "1992-02-02"));
        clients.add(new ClientModel(3L, "Alice", "Johnson", "alicejohnson", "alice.j@example.com",
                "555-123-4567", "789 Pine St", "Springfield", "USA", "12345", "1988-03-03"));
        clients.add(new ClientModel(4L, "Bob", "Brown", "bobbrown", "bob.brown@example.com",
                "555-987-6543", "321 Maple St", "Springfield", "USA", "12345", "1985-04-04"));
        clients.add(new ClientModel(5L, "Charlie", "Davis", "charliedavis", "charlie.d@example.com",
                "555-234-5678", "654 Cedar St", "Springfield", "USA", "12345", "1995-05-05"));
        clients.add(new ClientModel(6L, "Diana", "Wilson", "dianawilson", "diana.w@example.com",
                "555-345-6789", "987 Birch St", "Springfield", "USA", "12345", "1993-06-06"));
        clients.add(new ClientModel(7L, "Ethan", "Moore", "ethanmoore", "ethan.m@example.com",
                "555-456-7890", "123 Spruce St", "Springfield", "USA", "12345", "1991-07-07"));
        clients.add(new ClientModel(8L, "Fiona", "Taylor", "fionataylor", "fiona.t@example.com",
                "555-567-8901", "456 Willow St", "Springfield", "USA", "12345", "1989-08-08"));
        clients.add(new ClientModel(9L, "George", "Anderson", "georgeanderson", "george.a@example.com",
                "555-678-9012", "789 Cherry St", "Springfield", "USA", "12345", "1987-09-09"));
        clients.add(new ClientModel(10L, "Hannah", "Thomas", "hannahtomas", "hannah.t@example.com",
                "555-789-0123", "321 Birch St", "Springfield", "USA", "12345", "1994-10-10"));
    }

    public void addMockUsers() {
        users.add(new UserModel("Mariam", "Chikovani", "chikovanim", "late_assignment@submitter.com", "pass123",
                "555-1234", "Software Engineer", "User"));
        users.add(new UserModel("Anuki", "Kordzaia", "akordzaia", "good_student@angular.com", "pass123",
                "555-5678", "Project Manager", "Admin"));
        users.add(new UserModel("Charlie", "Williams", "charlie.williams", "charlie.w@example.com", "password123",
                "555-8765", "Business Analyst", "User"));
        users.add(new UserModel("Diana", "Brown", "diana.brown", "diana.brown@example.com", "password123",
                "555-4321", "Designer", "User"));
        users.add(new UserModel("Ethan", "Jones", "ethan.jones", "ethan.jones@example.com", "password123",
                "555-2468", "DevOps Engineer", "User"));
        users.add(new UserModel("Fiona", "Garcia", "fiona.garcia", "fiona.garcia@example.com", "password123",
                "555-1357", "Quality Assurance", "User"));
        users.add(new UserModel("George", "Martinez", "george.martinez", "george.m@example.com", "password123",
                "555-8642", "System Administrator", "Admin"));
        users.add(new UserModel("Hannah", "Davis", "hannah.davis", "hannah.davis@example.com", "password123",
                "555-7531", "Data Scientist", "User"));
        users.add(new UserModel("Ian", "Rodriguez", "ian.rodriguez", "ian.r@example.com", "password123",
                "555-9513", "Network Engineer", "User"));
        users.add(new UserModel("Julia", "Hernandez", "julia.hernandez", "julia.h@example.com", "password123",
                "555-1597", "Marketing Specialist", "User"));
    }
}
