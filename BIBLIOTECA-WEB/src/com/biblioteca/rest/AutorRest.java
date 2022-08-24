package com.biblioteca.rest;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import com.biblioteca.entidad.Autor;
import com.biblioteca.session.AutorSession;

@Path("/autor")
public class AutorRest {

	@EJB
	AutorSession as;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultar")
	public List<Autor> consultar() {
		return as.consultarAutores();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultar-por-nombre")
	// Parametros: """QueryParam""" (p/ valores simples, directos, enteros,
	// string..), PathParam, BodyParam
	// http://localhost:8082/BIBLIOTECA-WEB/rest/Autor/consultar-por-nombre?nombre=Ana
	public Map<String, Object> consultarPorNombre(@QueryParam("nombreQP") String nombre) {
		return as.consultarAutoresPorNombre(nombre);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar-por-codigo")
	public Autor buscarPorCodigo(@QueryParam("codigoQP") Integer codigo) {
		return as.buscarPorCodigo(codigo);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/incluir")
	// BodyParam
	public Autor incluir(Autor autor) {
		return as.incluir(autor);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/editar")
	// BodyParam
	public Autor editar(Autor autor) {
		return as.editar(autor);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/actualizar")
	// BodyParam
	public Autor actualizar(Autor autor) {
		return as.actualizar(autor);
	}
	
	@DELETE
	@Path("/eliminar/{id}")
	// PathParam
	public void eliminar(@PathParam("id") Integer codigo) {
		as.eliminar(codigo);
	}

	// Tarea para hoy: implementar editar, actualizar, buscarPorCodigo
	// Implementar formato de respuesta estandar via MAP como se hizo en consultar por nombre - Para la otra semana
}
