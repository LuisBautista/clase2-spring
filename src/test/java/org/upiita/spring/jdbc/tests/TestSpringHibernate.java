package org.upiita.spring.jdbc.tests;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.upiita.spring.jdbc.daos.UsuarioDAO;
import org.upiita.spring.jdbc.entidades.Usuario;

public class TestSpringHibernate {

	public static void main(String[] args) {
		//creamos el contexto de Spring
		ApplicationContext contexto = new ClassPathXmlApplicationContext("/contexto.xml");
	    UsuarioDAO usuarioDAO = (UsuarioDAO) contexto.getBean("usuarioDAO");
		
		Usuario usuarioNuevo = new Usuario();

		usuarioNuevo.setUsuarioId(3);
		usuarioNuevo.setNombre("Luis Ma");
		usuarioNuevo.setEmail("lm@gmial.com");				
		usuarioNuevo.setPassword("123");	
		
		// Guarda 
	    usuarioDAO.creaUsuario(usuarioNuevo);
   
	    
	    Usuario usuario = usuarioDAO.buscaUsuarioPorId(3);        
		System.out.println("Usuario:"+ usuario);
		
		
		Usuario usuarioPorEmail = usuarioDAO.buscaPorEmail("juan@email.com"); 
		
		System.out.println("Usuario por mail"+usuarioPorEmail);
		
		List<Usuario> usuarios = usuarioDAO.obtenPorNombre("a");		
		
		System.out.println("Usuarios: "+ usuarios);
	}

}
