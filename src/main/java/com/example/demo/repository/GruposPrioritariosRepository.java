package com.example.demo.repository;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.GruposPrioritarios;

@Entity
public interface GruposPrioritariosRepository extends JpaRepository<GruposPrioritarios, Long> {

}
