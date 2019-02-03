package com.alfredomarino.mislibros.core.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alfredomarino.mislibros.core.model.Usuario;

/**
 * UsuarioRepository
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public Usuario findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
}