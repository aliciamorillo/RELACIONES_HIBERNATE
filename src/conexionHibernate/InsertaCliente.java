package conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaCliente {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		
		try {
			
			Cliente cliente1 = new Cliente("MARTHA", "WAYNE", "calle Azul");
			
			DetallesCliente detallesCliente1 = new DetallesCliente("https://www.youtube.com/watch?v=OKfXRhKNLDk", "686121212", "Primer cliente");

			//Asociar los objetos:
			cliente1.setDetallesCliente(detallesCliente1);
			
			//Esto guarda la info en las dos tablas relacionadas
			
			session.beginTransaction();
			session.save(cliente1);
			
			session.getTransaction().commit();
			
			System.out.println("REGISTRO INSERTADO EN BD");
			
			
			session.close();
			
		} finally {
			factory.close();
		}
		
	}

}
