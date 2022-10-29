package com.biblioteca.abm.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.biblioteca.entidad.Libro;

@Stateless
public class LibroSession {

	@PersistenceContext(name = "BibliotecaPU")
	EntityManager em;

	// Consultar todos los libros
	public List<Libro> consultarLibros() {
		String jpql = "SELECT a FROM Libro a ORDER BY a.codigo";

		Query q = em.createQuery(jpql);
		List<Libro> libros = q.getResultList();

		return libros;
	}

	// Consultar libros por descripcion
	public List<Libro> consultarLibrosPorNombre(String descripcion) {
		String jpql = "select a from Libro a where upper(a.descripcion) like :n order by a.codigo";

		Query q = em.createQuery(jpql);
		q.setParameter("n", "%" + descripcion.toUpperCase() + "%");
		List<Libro> libros = q.getResultList();

		return libros;
	}

	// Buscar un libro por el codigo
	public Libro buscarPorCodigo(Integer codigo) {
		Libro libro = em.find(Libro.class, codigo);
		return libro;
	}

	public Libro incluir(Libro libro) {
		libro.setCodigo(null);
		em.persist(libro);// insertar
		em.refresh(libro);// consulta el dato insertado
		return libro;
	}

	public Libro editar(Libro libro) {
		libro = em.merge(libro);
		return libro;
	}

	public Libro actualizar(Libro libro) {
		Libro libroActualizado = null;
		Libro libroBuscar = buscarPorCodigo(libro.getCodigo());
		if (libroBuscar == null) {
			libroActualizado = incluir(libro);
		} else {
			libroActualizado = editar(libro);
		}
		return libroActualizado;
	}

	public void eliminar(Integer codigo) {
		Libro buscarLibro = em.find(Libro.class, codigo);
		if (buscarLibro != null) {
			em.remove(buscarLibro);
		}
	}

}
