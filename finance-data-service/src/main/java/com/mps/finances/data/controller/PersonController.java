package com.mps.finances.data.controller;

import com.mps.finances.PersonVo;
import com.mps.finances.data.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data/owners")
public class PersonController {

    @Autowired
    PersonService personService;


    @PostMapping
    public ResponseEntity<PersonVo> savePerson(@RequestBody PersonVo personVo) {
        personVo =personService.savePerson(personVo);
        return ResponseEntity.status(HttpStatus.CREATED).body(personVo);
    }

   /* @GetMapping
    public ResponseEntity getAllOwners() {
        //TODO: to be implemented
        return ResponseEntity
                .status(HttpStatus.NOT_IMPLEMENTED)
                .body(null);
    }*/


    @GetMapping(value = "/{ownerId}")
    public ResponseEntity<PersonVo> getAllOwners(@PathVariable("ownerId") Long ownerId) {
        PersonVo personVo = personService.getPersonById(ownerId);
        return ResponseEntity.ok(personVo);
    }

    @GetMapping
    public ResponseEntity<List<PersonVo>> getOwners(@RequestParam Map<String, String> requestParams) {

        List<PersonVo> personVos = personService.getPerson(requestParams);
        return ResponseEntity.ok(personVos);
    }


}
