package pedidos;

import java.util.Date;

import conexionHibernate.Cliente;

public class Pedido {
	
	private int id;
	private Date fecha;
	private String formaPago;
	private Cliente cliente;

}
