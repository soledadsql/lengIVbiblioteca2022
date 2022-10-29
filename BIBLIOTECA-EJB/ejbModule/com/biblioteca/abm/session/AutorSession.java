package com.biblioteca.abm.session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.biblioteca.entidad.Autor;

@Stateless
public class AutorSession {

	@PersistenceContext(name = "BibliotecaPU")
	EntityManager em;

	// Consultar todos los autores
	public List<Autor> consultarAutores() {
		String jpql = "SELECT a FROM Autor a ORDER BY a.codigo";

		Query q = em.createQuery(jpql);
		List<Autor> autores = q.getResultList();

		return autores;
	}
	
	public Map<String, Object> consultarAutoresv2() {
		Map<String, Object> retorno = new HashMap<String, Object>(); // {}
		try {
			String jpql = "SELECT a FROM Autor a ORDER BY a.codigo";

			Query q = em.createQuery(jpql);
			List<Autor> autores = q.getResultList();
			retorno.put("success", true);
			retorno.put("result", autores);
		} catch (Exception e) {
			retorno.put("success", false);
			retorno.put("error", e.getMessage());
		}
		return retorno;
	}

	// Consultar autores por nombre
	public List<Autor> consultarAutoresPorNombre(String nombre) {
		String jpql = "select a from Autor a where upper(a.nombre) like :n order by a.codigo";

		Query q = em.createQuery(jpql);
		q.setParameter("n", "%" + nombre.toUpperCase() + "%");
		List<Autor> autores = q.getResultList();

		return autores;
	}

	public Map<String, Object> consultarAutoresPorNombrev2(String nombre) {
		Map<String, Object> retorno = new HashMap<String, Object>(); // {}
		try {
			String jpql = "select a from Autor a where upper(a.nombre) like :n order by a.codigo";

			Query q = em.createQuery(jpql);
			q.setParameter("n", "%" + nombre.toUpperCase() + "%");
			List<Autor> autores = q.getResultList();
			retorno.put("success", true);
			retorno.put("result", autores);
		} catch (Exception e) {
			retorno.put("success", false);
			retorno.put("error", e.getMessage());
		}
		return retorno;
	}

	// Buscar un autor por el codigo	
	public Autor buscarPorCodigo(Integer codigo) {
		Autor autor = em.find(Autor.class, codigo);
		return autor;
	}

	/*
	 * este metodo inserta un autor en la base de datos utilizando el entity manager
	 */
	public Autor incluir(Autor autor) {
		autor.setCodigo(null); 
		em.persist(autor);// insertar
		em.refresh(autor);// consulta el dato insertado
		return autor;
	}

	public Autor editar(Autor autor) {
		autor = em.merge(autor);
		return autor;
	}

	// incluye o edita un autor dependiendo si existe o no
	public Autor actualizar(Autor autor) {
		Autor autorActualizado = null;
		Autor autorBuscar = buscarPorCodigo(autor.getCodigo());
		if (autorBuscar == null) {
			autorActualizado = incluir(autor);
		} else {
			autorActualizado = editar(autor);
		}
		return autorActualizado;
	}

	public void eliminar(Integer codigo) {
		//falta validar que pasa si se quiere eliminar codigo que no existe
		//{success:false, error:"Autor con #4 no existe"}
		Autor autorBuscar = em.find(Autor.class, codigo);
		if (autorBuscar!=null) {
			em.remove(autorBuscar);
		}
		// return null;
	}
}
