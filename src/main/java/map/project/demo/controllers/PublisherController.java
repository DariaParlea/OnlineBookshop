package map.project.demo.controllers;

import map.project.demo.entities.Publisher;
import map.project.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Publishers")
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public List<Publisher> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    @GetMapping("/{PublisherId}")
    public Publisher getPublisherById(@PathVariable int PublisherId) {
        return publisherService.getPublisherById(PublisherId).orElse(null);
    }

    @PostMapping
    public Publisher savePublisher(@RequestBody Publisher publisher) {
        return publisherService.savePublisher(publisher);
    }

    @DeleteMapping("/{PublisherId}")
    public void deletePublisher(@PathVariable int PublisherId) {
        publisherService.deletePublisher(PublisherId);
    }
}
