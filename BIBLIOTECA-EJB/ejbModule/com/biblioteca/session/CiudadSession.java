package com.biblioteca.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.biblioteca.entidad.Ciudad;

@Stateless
public class CiudadSession {

	@PersistenceContext(name="BibliotecaPU")
	EntityManager em;

	// Consultar todas las ciudades
	public List<Ciudad> consultarCiudades() {
		String jpql = "SELECT a FROM Ciudad a ORDER BY a.codigo";

		Query q = em.createQuery(jpql);
		List<Ciudad> ciudades = q.getResultList();

		return ciudades;
	}

	// Consultar ciudades por descripcion
	public List<Ciudad> consultarCiudadesPorNombre(String descripcion) {
		String jpql = "select a from Ciudad a where upper(a.descripcion) like :n order by a.codigo";

		Query q = em.createQuery(jpql);
		q.setParameter("n", "%" + descripcion.toUpperCase() + "%");
		List<Ciudad> ciudades = q.getResultList();

		return ciudades;
	}

	// Buscar un ciudad por el codigo
	public Ciudad buscarPorCodigo(Integer codigo) {
		Ciudad ciudad = em.find(Ciudad.class, codigo);
		return ciudad;
	}

	public Ciudad incluir(Ciudad ciudad) {
		em.persist(ciudad);// insertar
		em.refresh(ciudad);// consulta el dato insertado
		return ciudad;
	}

	public Ciudad editar(Ciudad ciudad) {
		ciudad = em.merge(ciudad);
		return ciudad;
	}

	// incluye o edita una ciudad dependiendo si existe o no
	private Ciudad actualizar(Ciudad ciudad) {
		Ciudad ciudadActualizado = null;
		Ciudad ciudadBuscar = buscarPorCodigo(ciudad.getCodigo());
		if (ciudadBuscar == null) {
			ciudadActualizado = incluir(ciudad);
		} else {
			ciudadActualizado = editar(ciudad);
		}
		return ciudadActualizado;
	}

	public void eliminar(Integer codigo) {
		em.remove(codigo);
		// return null;
	}
}
