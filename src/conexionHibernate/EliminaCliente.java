package conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaCliente {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		
		try {
			session.beginTransaction();
			
			Cliente cliente = session.get(Cliente.class, 4);
			
			session.getTransaction().commit();
			
			if (cliente != null) {
				System.out.println("VOY A ELIMINAR AL CLIENTE -> " + cliente.getNombre());
				session.delete(cliente);
				System.out.println("REGISTRO ELIMINADO CORRECTAMENTE");
			} else {
				System.out.println("NADA QUE ELIMINAR");
			}
			
			session.close();
			
		} finally {
			factory.close();
		}
		
	}

}
