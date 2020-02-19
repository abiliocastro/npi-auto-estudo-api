package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Contato;

public interface IContatoRepository extends JpaRepository<Contato, Long> {

}