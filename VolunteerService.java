package com.volunteer.service;

import com.volunteer.model.Volunteer;
import com.volunteer.repository.VolunteerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService {

    private final VolunteerRepository repository;

    public VolunteerService(VolunteerRepository repository) {
        this.repository = repository;
    }

    public List<Volunteer> getAllVolunteers() {
        return repository.findAll();
    }

    public Volunteer getVolunteerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Volunteer> getAvailableVolunteers() {
        return repository.findByAvailabilityTrue();
    }

    public Volunteer createVolunteer(Volunteer volunteer) {
        return repository.save(volunteer);
    }

    public Volunteer updateVolunteer(Long id, Volunteer updated) {
        Volunteer v = repository.findById(id).orElse(null);
        if (v != null) {
            v.setName(updated.getName());
            v.setEmail(updated.getEmail());
            v.setAvailability(updated.isAvailability());
            return repository.save(v);
        }
        return null;
    }

    public void deleteVolunteer(Long id) {
        repository.deleteById(id);
    }
}
