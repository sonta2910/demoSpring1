package com.example.demospringboot1.controller;

import com.example.demospringboot1.model.SmartPhone;
import com.example.demospringboot1.service.impl.SmartPhoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/smartphones")
public class SmartPhoneController {
    @Autowired
    private SmartPhoneServiceImpl smartPhoneService;
    @GetMapping
    public ResponseEntity<List<SmartPhone>> findAll() {
        List<SmartPhone> smartPhones = smartPhoneService.findAll();
        if (smartPhones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartPhones, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody SmartPhone smartPhone){
        smartPhoneService.save(smartPhone);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        smartPhoneService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SmartPhone> findOne(@PathVariable Long id) {
        return new ResponseEntity<>(smartPhoneService.findById(id), HttpStatus.OK);
    }
}


