package map.project.demo.controllers;

import map.project.demo.service.ClientsService;
import map.project.demo.entities.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Clients")
public class ClientsController {

    private final ClientsService clientsService;

    @Autowired
    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @GetMapping
    public List<Clients> getAllClients() {
        return clientsService.getAllClients();
    }

    @GetMapping("/{ClientID}")
    public Clients getClientById(@PathVariable int ClientID) {
        return clientsService.getClientById(ClientID)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + ClientID));
    }

    @PostMapping
    public Clients createClient(@RequestBody Clients client) {
        return clientsService.createClient(client);
    }

    @PutMapping("/{ClientID}")
    public Clients updateClient(@PathVariable int ClientID, @RequestBody Clients updatedClient) {
        return clientsService.updateClient(ClientID, updatedClient);
    }

    @DeleteMapping("/{ClientID}")
    public String deleteClient(@PathVariable int ClientID) {
        clientsService.deleteClient(ClientID);
        return "Client deleted successfully";
    }
}