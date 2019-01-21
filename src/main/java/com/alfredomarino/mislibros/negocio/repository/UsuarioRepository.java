package com.alfredomarino.mislibros.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alfredomarino.mislibros.modelo.Usuario;

/**
 * UsuarioRepository
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public Usuario findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
}