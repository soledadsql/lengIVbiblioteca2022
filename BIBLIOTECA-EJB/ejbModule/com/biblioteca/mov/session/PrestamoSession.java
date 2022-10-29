package com.biblioteca.mov.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.biblioteca.entidad.Prestamo;

@Stateless
public class PrestamoSession {
	
	@PersistenceContext(name = "BibliotecaPU")
	EntityManager em;

	// Consultar todos los prestamos
	public List<Prestamo> consultarPrestamos() {
		String jpql = "SELECT a FROM Prestamo a ORDER BY a.codigo";

		Query q = em.createQuery(jpql);
		List<Prestamo> prestamos = q.getResultList();

		return prestamos;
	}

	// Consultar prestamos por descripcion
	public List<Prestamo> consultarPrestamosPorNombreCliente(String nombre) {
		String jpql = "select a from Prestamo a where upper(a.cliente.nombre) like :n order by a.codigo";

		Query q = em.createQuery(jpql);
		q.setParameter("n", "%" + nombre.toUpperCase() + "%");
		List<Prestamo> prestamos = q.getResultList();

		return prestamos;
	}

	// Buscar un prestamo por el codigo
	public Prestamo buscarPorCodigo(Integer codigo) {
		Prestamo prestamo = em.find(Prestamo.class, codigo);
		return prestamo;
	}

	public Prestamo incluir(Prestamo prestamo) {
		prestamo.setCodigo(null);
		em.persist(prestamo);// insertar
		em.refresh(prestamo);// consulta el dato insertado
		return prestamo;
	}

	public Prestamo editar(Prestamo prestamo) {
		prestamo = em.merge(prestamo);
		return prestamo;
	}

	// incluye o edita un prestamo dependiendo si existe o no
	public Prestamo actualizar(Prestamo prestamo) {
		Prestamo prestamoActualizado = null;
		Prestamo prestamoBuscar = buscarPorCodigo(prestamo.getCodigo());
		if (prestamoBuscar == null) {
			prestamoActualizado = incluir(prestamo);
		} else {
			prestamoActualizado = editar(prestamo);
		}
		return prestamoActualizado;
	}

	public Prestamo anular(Integer codigo) {
		Prestamo prestamo = buscarPorCodigo(codigo);
		if (prestamo != null) {
			prestamo.setSituacion(1);
			em.merge(prestamo);
		}
		return prestamo;
	}
}
