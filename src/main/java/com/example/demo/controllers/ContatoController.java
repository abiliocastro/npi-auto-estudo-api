package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Contato;
import com.example.demo.services.ContatoService;

@RestController
@RequestMapping({"/contato"})
public class ContatoController {

   @Autowired
   ContatoService contatoService;

   @PostMapping
   public void create(@RequestBody Contato contato){
      contatoService.cadastrar(contato);
   }
   
   @GetMapping(path = {"/{id}"})
   public ResponseEntity<Contato> findById(@PathVariable long id){
	   return contatoService.obterContato(id);
   }
   
   @GetMapping
   public List<Contato> findAll(){
      return contatoService.retornarContatos();
   }
   
   @PutMapping(path= {"/{id}"})
   public ResponseEntity<Contato> update(@PathVariable("id") long id,
                                         @RequestBody Contato contato) {
      return contatoService.atualizar(id, contato);
   }
   
   @DeleteMapping(path ={"/{id}"})
   public ResponseEntity<?> delete(@PathVariable long id) {
	  return contatoService.deletar(id);
   }

} 
