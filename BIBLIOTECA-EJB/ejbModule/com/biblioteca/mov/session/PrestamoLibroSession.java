package com.biblioteca.mov.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.biblioteca.entidad.PrestamoLibro;

@Stateless
public class PrestamoLibroSession {

	@PersistenceContext(name = "BibliotecaPU")
	EntityManager em;

	public List<PrestamoLibro> consultarPrestamosPorNombre(String prestamo) {
		String jpql = "select a from PrestamoLibro a where upper(a.prestamo) like :n order by a.codigo";

		Query q = em.createQuery(jpql);
		q.setParameter("n", "%" + prestamo.toUpperCase() + "%");
		List<PrestamoLibro> prestamoLibro = q.getResultList();

		return prestamoLibro;
	}

	public void eliminarPorPrestamo(Integer prestamo) {
		Query q = em.createQuery("delete from PrestamoLibro p where p.prestamo=" + prestamo);
		q.executeUpdate();
	}

}
