package com.volunteer.controller;

import com.volunteer.model.Volunteer;
import com.volunteer.service.VolunteerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {

    private final VolunteerService service;

    public VolunteerController(VolunteerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Volunteer> getAll() {
        return service.getAllVolunteers();
    }

    @GetMapping("/{id}")
    public Volunteer getById(@PathVariable Long id) {
        return service.getVolunteerById(id);
    }

    @GetMapping("/available")
    public List<Volunteer> getAvailable() {
        return service.getAvailableVolunteers();
    }

    @PostMapping
    public Volunteer create(@RequestBody Volunteer volunteer) {
        return service.createVolunteer(volunteer);
    }

    @PutMapping("/{id}")
    public Volunteer update(@PathVariable Long id, @RequestBody Volunteer volunteer) {
        return service.updateVolunteer(id, volunteer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteVolunteer(id);
    }
}
