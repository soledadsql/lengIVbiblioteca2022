package com.biblioteca.rest;

import java.util.HashMap;
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
	public Map<String, Object> consultar() {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("autor", as.consultarAutores());
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultar-por-nombre")
	// Parametros: """QueryParam""" (p/ valores simples, directos, enteros,
	// string..), PathParam, BodyParam
	// http://localhost:8082/BIBLIOTECA-WEB/rest/Autor/consultar-por-nombre?nombre=Ana
	public Map<String, Object> consultarPorNombre(@QueryParam("nombreQP") String nombre) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("autor", as.consultarAutoresPorNombre(nombre));
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar-por-codigo")
	public Map<String, Object> buscarPorCodigo(@QueryParam("codigoQP") Integer codigo) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("autor", as.buscarPorCodigo(codigo));
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/incluir")
	// BodyParam
	public Map<String, Object> incluir(Autor autor) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("autor", as.incluir(autor));
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/editar")
	// BodyParam
	public Map<String, Object> editar(Autor autor) {
		Map<String, Object> retorno = new HashMap<String, Object>(); // {}
		try {
			retorno.put("success", true);
			retorno.put("autor", as.editar(autor));
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/actualizar")
	// BodyParam
	public Map<String, Object> actualizar(Autor autor) {
		Map<String, Object> retorno = new HashMap<String, Object>(); // {}
		try {
			retorno.put("success", true);
			retorno.put("autor", as.actualizar(autor));
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}

	@DELETE
	@Path("/eliminar/{id}")
	// PathParam
	public void eliminarv1(@PathParam("id") Integer codigo) {
		as.eliminar(codigo);
	}
	@DELETE
	@Path("/eliminar/{id}")
	// PathParam
	public Map<String, Object> eliminar(@PathParam("id") Integer codigo) {
		Map<String, Object> retorno = new HashMap<String, Object>(); 
		try {
			retorno.put("success", true);
			as.eliminar(codigo);
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}

	// Tarea para hoy: implementar editar, actualizar, buscarPorCodigo
	// Implementar formato de respuesta estandar via MAP como se hizo en consultar
	// por nombre - Para la otra semana
}
