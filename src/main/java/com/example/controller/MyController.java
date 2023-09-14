package com.example.controller;

import com.example.model.Parent;
import com.example.repository.ParentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@Component
@RestController
public class MyController {

    private final ParentRepository parentRepository;

    public MyController(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @GetMapping(value = "/parents")
    public ResponseEntity<List<Parent>> getParents() {
        return ResponseEntity.ok(parentRepository.findAll());
    }

    @PostMapping(value = "/parents/{id}/unlink")
    public ResponseEntity<Integer> unlinkChildrenFromParent(@PathVariable("id") final Integer id) {
        Optional<Parent> parent = parentRepository.findById(id);
        if (parent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        int unlinkedChildrenCount = parent.get().unlinkOddChildren();
        parentRepository.save(parent.get());
        return ResponseEntity.ok(unlinkedChildrenCount);
    }
}
