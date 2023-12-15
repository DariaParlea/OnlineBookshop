package map.project.demo.service;

import map.project.demo.repositories.ClientsRepository;
import map.project.demo.entities.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {

    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }

    public Optional<Clients> getClientById(int id) {
        return clientsRepository.findById(id);
    }

    public Clients createClient(Clients client) {
        return clientsRepository.save(client);
    }

    public Clients updateClient(int id, Clients updatedClient) {
        Clients existingClient = clientsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));

        existingClient.setFirstName(updatedClient.getFirstName());
        existingClient.setLastName(updatedClient.getLastName());
        existingClient.setBirth_date(updatedClient.getBirth_date());
        existingClient.setAddress(updatedClient.getAddress());
        existingClient.setEmail(updatedClient.getEmail());

        return clientsRepository.save(existingClient);
    }

    public void deleteClient(int id) {
        clientsRepository.deleteById(id);
    }
}