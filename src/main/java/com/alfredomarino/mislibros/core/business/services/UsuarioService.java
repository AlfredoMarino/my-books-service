package com.alfredomarino.mislibros.core.business.services;


import com.alfredomarino.mislibros.core.model.Usuario;
import com.alfredomarino.mislibros.core.business.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena) {
        return usuarioRepository.findByNombreUsuarioAndContrasena(nombreUsuario, contrasena);
    }

}