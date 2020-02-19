package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Contato;
import com.example.demo.repository.IContatoRepository;

@Service
public class ContatoService {
	@Autowired
	IContatoRepository iContatoRepository;
	
	public void cadastrar(Contato contato) {		
		iContatoRepository.save(contato);
		
	}
	
	public ResponseEntity<Contato> atualizar(long id, Contato contato) {
		return iContatoRepository.findById(id)
	              .map(record -> {
	                  record.setNome(contato.getNome());
	                  record.setTelefone(contato.getTelefone());
	                  Contato updated = iContatoRepository.save(record);
	                  return ResponseEntity.ok().body(updated);
	              }).orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<Contato> obterContato(Long id){
		return iContatoRepository.findById(id)
	              .map(record -> ResponseEntity.ok().body(record))
	              .orElse(ResponseEntity.notFound().build());
	}
	
	public List<Contato> retornarPratos(){
		return iContatoRepository.findAll();
	}

	public ResponseEntity<?> deletar(Long id) {
		return iContatoRepository.findById(id)
	              .map(record -> {
	            	  iContatoRepository.deleteById(id);
	                  return ResponseEntity.ok().build();
	              }).orElse(ResponseEntity.notFound().build());		
	}
}