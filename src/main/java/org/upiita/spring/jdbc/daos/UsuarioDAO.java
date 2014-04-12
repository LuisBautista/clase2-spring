package org.upiita.spring.jdbc.daos;

import java.util.List;

import org.upiita.spring.jdbc.entidades.Usuario;

public interface UsuarioDAO {

	public Usuario buscaUsuarioPorId(Integer usuarioId);

	public void creaUsuario(Usuario usuario);
		
	public Usuario buscaPorEmail(String email );
	
    public List<Usuario> obtenPorNombre(String nombre);	
}
