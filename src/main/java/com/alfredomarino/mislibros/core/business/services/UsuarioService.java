package com.alfredomarino.mislibros.core.business.services;

import com.alfredomarino.mislibros.core.model.Usuario;

public interface UsuarioService {

    Usuario findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
}
