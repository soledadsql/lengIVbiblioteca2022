package com.biblioteca.rest;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.biblioteca.mov.session.PrestamoLibroSession;


@Path("/prestamoLibro")
public class PrestamoLibroRest {
	@EJB
	PrestamoLibroSession pls;

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultar-por-nombre")
	public Map<String, Object> consultarPorNombre(@QueryParam("nombreQP") String prestamo) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("prestamoLibro", pls.consultarPrestamosPorNombre(prestamo));
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/eliminarPorPrestamo/{id}")
	// PathParam
	public Map<String, Object> eliminar(@PathParam("id") Integer codigo) {
		Map<String, Object> retorno = new HashMap<String, Object>(); 
		try {
			retorno.put("success", true);
			pls.eliminarPorPrestamo(codigo);
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}
}
