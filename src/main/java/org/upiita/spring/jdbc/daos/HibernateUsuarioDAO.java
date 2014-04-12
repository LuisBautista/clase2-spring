package org.upiita.spring.jdbc.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.upiita.spring.jdbc.entidades.Usuario;

@Component("usuarioDAO")
public class HibernateUsuarioDAO implements UsuarioDAO {
  // clase de utileria de hiberante
	@Autowired
	private SessionFactory sessionFatory;
	
	public Usuario buscaUsuarioPorId(Integer usuarioId) {
        // crea la session hibernate
	    Session sesion =   sessionFatory.openSession();
	    /// se habre una transaccion
	    sesion.beginTransaction();
		// busca por id en la tabla mapeada por la clase usuario
	    // que sea igual al usurario 
	    //si no encuentra nada regresa null
	    Usuario usuario =  (Usuario) sesion.get(Usuario.class,usuarioId);
	    sesion.getTransaction().commit();
	    sesion.close();
		return usuario;
	}

	public void creaUsuario(Usuario usuario) {
		Session sesion =   sessionFatory.openSession();
	    sesion.beginTransaction();
	    
	    // crea un nuevo reglon culas columna se llegana con las propiedaddes de la case ususario
	    // esto es igual a un insert sql
        sesion.save(usuario);	    
	    
	    sesion.getTransaction().commit();
	    sesion.close();
	}
   public Usuario buscaPorEmail(String email ){
		Session sesion =   sessionFatory.openSession();
	    sesion.beginTransaction();
	    
        Criteria criterio = sesion.createCriteria(Usuario.class);
	    criterio.add(Restrictions.eq("email", email));
	    
	    // si se sabe q se regreasara una sola entidad
	    Usuario usuario =   (Usuario) criterio.uniqueResult();
	    
	    sesion.getTransaction().commit();
	    sesion.close();	   
	       
	   return usuario;
  }
   
   public List<Usuario> obtenPorNombre(String nombre){
		Session sesion =   sessionFatory.openSession();
	    sesion.beginTransaction();
	    
        Criteria criterio = sesion.createCriteria(Usuario.class);
	    criterio.add(Restrictions.not(Restrictions.like("nombre", "%"+nombre+"%")));
	    
	    
	    List<Usuario> usuarios =    criterio.list();	    
	    sesion.getTransaction().commit();
	    sesion.close();	   
	       
	   return usuarios;  
	   
   }
   
   
   
   
   
	
}
