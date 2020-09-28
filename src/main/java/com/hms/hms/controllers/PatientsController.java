package com.hms.hms.controllers;

import com.hms.hms.models.Patient;
import com.hms.hms.repositories.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientsController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public List<Patient> list() {
        return patientRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Patient get(@PathVariable Long id) {
        return patientRepository.getOne(id);
    }

    @PostMapping
    public Patient create(@RequestBody Patient patient){
        return patientRepository.saveAndFlush(patient);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //Also need to check for children records before deleting.
        patientRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Patient update(@PathVariable Long id, @RequestBody Patient patient) {
        //because this is a PUT, we expect all attributes to be passed in. A PATCH would only need what has changed.
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Patient existingPatient = patientRepository.getOne(id);
        BeanUtils.copyProperties(patient, existingPatient, "patient_id");
        return patientRepository.saveAndFlush(existingPatient);
    }
}
