package ua.lviv.iot.Lab_rest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.Lab_rest.model.WritingDesk;
import ua.lviv.iot.Lab_rest.service.WritingDeskService;

import java.util.List;


@RestController

public class WritingDeskController {

    private final WritingDeskService writingDeskService;


    @Autowired
    public WritingDeskController(WritingDeskService writingDeskService) {
        this.writingDeskService = writingDeskService;

    }

    @PostMapping(value = "/desks")
    public ResponseEntity<?> create(@RequestBody WritingDesk writingDesk) {
        writingDeskService.create(writingDesk);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/desks")
    public ResponseEntity<List<WritingDesk>> read() {
        final List<WritingDesk> clients = writingDeskService.readAll();

        return clients != null &&  !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/desks/{id}")
    public ResponseEntity<WritingDesk> read(@PathVariable(name = "id") int id) {
        final WritingDesk client = writingDeskService.read(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/desks/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody WritingDesk writingDesk) {
        final boolean updated = writingDeskService.update(writingDesk, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/desks/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = writingDeskService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}