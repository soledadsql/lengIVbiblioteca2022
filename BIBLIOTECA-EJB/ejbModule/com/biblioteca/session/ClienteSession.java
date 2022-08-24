package com.biblioteca.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.biblioteca.entidad.Cliente;

@Stateless
public class ClienteSession {

	@PersistenceContext(name="BibliotecaPU")
	EntityManager em;

	// Consultar todos los clientes
	public List<Cliente> consultarClientes() {
		String jpql = "SELECT a FROM Cliente a ORDER BY a.codigo";

		Query q = em.createQuery(jpql);
		List<Cliente> clientes = q.getResultList();

		return clientes;
	}

	// Consultar clientes por descripcion
	public List<Cliente> consultarClientesPorNombre(String nombre) {
		String jpql = "select a from Cliente a where upper(a.nombre) like :n order by a.codigo";

		Query q = em.createQuery(jpql);
		q.setParameter("n", "%" + nombre.toUpperCase() + "%");
		List<Cliente> clientes = q.getResultList();

		return clientes;
	}

	// Buscar un cliente por el codigo
	public Cliente buscarPorCodigo(Integer codigo) {
		Cliente cliente = em.find(Cliente.class, codigo);
		return cliente;
	}

	public Cliente incluir(Cliente cliente) {
		em.persist(cliente);// insertar
		em.refresh(cliente);// consulta el dato insertado
		return cliente;
	}

	public Cliente editar(Cliente cliente) {
		cliente = em.merge(cliente);
		return cliente;
	}

	// incluye o edita un cliente dependiendo si existe o no
	private Cliente actualizar(Cliente cliente) {
		Cliente clienteActualizado = null;
		Cliente clienteBuscar = buscarPorCodigo(cliente.getCodigo());
		if (clienteBuscar == null) {
			clienteActualizado = incluir(cliente);
		} else {
			clienteActualizado = editar(cliente);
		}
		return clienteActualizado;
	}

	public void eliminar(Integer codigo) {
		em.remove(codigo);
		// return null;
	}

}
