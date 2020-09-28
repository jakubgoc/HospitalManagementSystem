package com.hms.hms.controllers;

import com.hms.hms.models.Doctor;
import com.hms.hms.repositories.DoctorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorsController {
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public List<Doctor> list() {
        return doctorRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Doctor get(@PathVariable Long id) {
        return doctorRepository.getOne(id);
    }

    @PostMapping
    public Doctor create(@RequestBody final Doctor doctor){
        return doctorRepository.saveAndFlush(doctor);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //Also need to check for children records before deleting.
        doctorRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Doctor update(@PathVariable Long id, @RequestBody Doctor doctor) {
        //because this is a PUT, we expect all attributes to be passed in. A PATCH would only need what has changed.
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Doctor existingDoctor = doctorRepository.getOne(id);
        BeanUtils.copyProperties(doctor, existingDoctor, "session_id");
        return doctorRepository.saveAndFlush(existingDoctor);
    }

}

