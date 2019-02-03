package com.alfredomarino.mislibros.core.controller.resources;

import com.alfredomarino.mislibros.core.model.Usuario;
import com.alfredomarino.mislibros.core.business.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UsuarioController
 */
@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Usuario> getUsuario(
        @RequestParam(value="nombreUsuario") String nombreUsuario, 
        @RequestParam(value="contrasena") String contrasena) {
        

        return new ResponseEntity<Usuario>(this.usuarioService.findByNombreUsuarioAndContrasena(nombreUsuario, contrasena), HttpStatus.OK);
    }
    
}