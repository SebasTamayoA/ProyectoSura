package com.example.sura.repository;

import com.example.sura.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // all crud database methods
}