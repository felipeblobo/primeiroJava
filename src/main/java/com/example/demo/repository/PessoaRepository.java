package com.example.demo.repository;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Pessoa;

@Entity
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
