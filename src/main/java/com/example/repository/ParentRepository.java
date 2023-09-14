package com.example.repository;

import com.example.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ParentRepository extends JpaRepository<Parent, Integer> {
}
