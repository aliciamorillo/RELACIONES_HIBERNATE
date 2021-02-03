package conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaDetallesCliente {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		
		try {
			session.beginTransaction();
			
			DetallesCliente detalleCliente = session.get(DetallesCliente.class, 2);
			
			detalleCliente.getCliente().setDetallesCliente(null);
			
			session.delete(detalleCliente);
			System.out.println("REGISTRO ELIMINADO CORRECTAMENTE");
			
			session.getTransaction().commit();

			session.close();
			
		} finally {
			factory.close();
		}
		
	}

}
