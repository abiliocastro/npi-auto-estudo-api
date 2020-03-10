package com.example.demo.services;


import com.example.demo.models.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario findByEmail(String email);

    List<Usuario> findAll();
}
