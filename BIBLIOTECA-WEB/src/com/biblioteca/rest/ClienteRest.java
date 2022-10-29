package com.biblioteca.rest;

import java.util.HashMap;
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

import com.biblioteca.abm.session.ClienteSession;
import com.biblioteca.entidad.Cliente;

@Path("/cliente")
public class ClienteRest {

	@EJB
	ClienteSession cs;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultar")
	public Map<String, Object> consultar() {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("cliente", cs.consultarClientes());
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultar-por-nombre")
	public Map<String, Object> consultarPorNombre(@QueryParam("nombreQP") String nombre) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("cliente", cs.consultarClientesPorNombre(nombre));
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
			retorno.put("cliente", cs.buscarPorCodigo(codigo));
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/incluir")
	public Map<String, Object> incluir(Cliente cliente) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			retorno.put("success", true);
			retorno.put("cliente", cs.incluir(cliente));
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
	public Map<String, Object> editar(Cliente cliente) {
		Map<String, Object> retorno = new HashMap<String, Object>(); // {}
		try {
			retorno.put("success", true);
			retorno.put("cliente", cs.editar(cliente));
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/actualizar")
	public Map<String, Object> actualizar(Cliente cliente) {
		Map<String, Object> retorno = new HashMap<String, Object>(); // {}
		try {
			retorno.put("success", true);
			retorno.put("cliente", cs.actualizar(cliente));
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/eliminar/{id}")
	public Map<String, Object> eliminar(@PathParam("id") Integer codigo) {
		Map<String, Object> retorno = new HashMap<String, Object>(); 
		try {
			retorno.put("success", true);
			cs.eliminar(codigo);
		} catch (Exception e) {
			retorno.put("error", e.getMessage());
			retorno.put("success", false);
		}
		return retorno;
	}

}
