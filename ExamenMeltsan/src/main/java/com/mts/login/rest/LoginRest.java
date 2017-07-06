package com.mts.login.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mts.domain.CommonRequest;
import com.mts.domain.CommonRequestRoles;
import com.mts.domain.CommonResponse;
import com.mts.login.service.LoginServiceImpl;
import com.mts.login.vo.PantallasVO;
import com.mts.login.vo.RolVO;
import com.mts.login.vo.RolesVO;
import com.mts.login.vo.UserVO;

import testSpringItc.HelloWord;

/* 4
 * se mapean los metodos con json
 * median los servicios 
 */

@Component
@Path("login")
public class LoginRest {

	@Autowired
	private LoginServiceImpl loginService;

	private static final Logger LOG = Logger.getLogger(LoginRest.class);

	@POST
	@Path("inicio")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse initCatalog(CommonRequest params) {

		CommonResponse respuesta = new CommonResponse();
		UserVO valores = new UserVO();

		if (LOG.isDebugEnabled()) {
			LOG.debug("MENSAJE CON LOG4J");
			LOG.debug(valores.getPass());
			LOG.debug(valores.getUser());
		}
		if (valores.getPass().equals(params.getKey()) && valores.getUser().equals(params.getId())) {
			respuesta.setSuccess(true);
			respuesta.setMensaje("Acceso Permitido");

		} else {
			respuesta.setSuccess(false);
			respuesta.setErrorMensaje("Acceso Denegado");
		}

		return respuesta;

	}

	@POST
	@Path("roles")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<RolesVO> roles() {

		return loginService.roles();

	}

	@POST
	@Path("pantallas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<PantallasVO> pantallas() {

		return loginService.pantallas();

	}

	@POST
	@Path("listaRoles")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<RolVO> rol() {

		return loginService.rol();

	}

	@POST
	@Path("NewUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse insertUsuarios(CommonRequestRoles params) {

		CommonResponse respuesta = new CommonResponse();

		if (LOG.isDebugEnabled()) {
			LOG.debug(".:- NewUser -:.");
			LOG.debug("rol : " + params.getRol());
			LOG.debug("dsrol : " + params.getDsrol());
			LOG.debug("swanalista : " + params.getSwanalista());
			LOG.debug("vigencia : " + params.getVigencia());
		}
		System.out.println("logitud = " + params.getRol().length());
		String mensaje = "";

		if (params.getSwanalista().equals("s")) {
			params.setSwanalista("S");
		}
		if (params.getSwanalista().equals("n")) {
			params.setSwanalista("N");
		}

		if (params.getSwanalista().equals("S") || params.getSwanalista().equals("N")) {
			if (params.getRol().length() > 4 && params.getRol().length() < 30) {
				
				if(!params.getDsrol().equals("") || !params.getVigencia().equals("")){

					respuesta.setSuccess(true);
					respuesta.setMensaje("Operación Correcta");
					loginService.insertUsuarios(params);
				}else{
					respuesta.setSuccess(false); 
					respuesta.setErrorMensaje("Deve Llenar Todos Los Campos");
				}
			} else {
				respuesta.setSuccess(false);
				respuesta.setErrorMensaje("Rol deve contener minimo 5 caracteres, maximo 30");
			}
		} else {
			respuesta.setSuccess(false);
			respuesta.setErrorMensaje("Revise el Campo Vigencia,\n escriba S o N");
		}

		return respuesta;

	}

	@POST
	@Path("updateUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse updateUsuarios(CommonRequestRoles params) {

		CommonResponse respuesta = new CommonResponse();

		if (LOG.isDebugEnabled()) {
			LOG.debug(".: updateUser :.");
			LOG.debug("VIGENCIA = " + params.getVigencia());
			LOG.debug("getActualizado_por = " + params.getActualizado_por());
			LOG.debug("getDsrol = " + params.getDsrol());
			LOG.debug("getSw_analista = " + params.getSwanalista());
			LOG.debug("getRoldi = " + params.getRoldi());
		}

		if (params.getSwanalista().equals("s")) {
			params.setSwanalista("S");
		}
		if (params.getSwanalista().equals("n")) {
			params.setSwanalista("N");
		}
		
		if(!params.getVigencia().equals("") && !params.getSwanalista().equals("") && !params.getDsrol().equals("")){
			if(params.getSwanalista().length()==1){
				loginService.actualizarUsuarios(params);
				respuesta.setSuccess(true);
				respuesta.setMensaje("Operacíón Exitosa");
				System.out.println("------------------------......................Operacíón Exitosa");
			}else{
				respuesta.setSuccess(false);
				respuesta.setErrorMensaje("Solo Deve Escribir 'S' o 'N'\nen el campo SW ANALISTA");
				System.out.println("-------------------------------------.....................Solo Deve Escribir 'S' o 'N'\nen el campo SW ANALISTA");
			}
		}else{
			respuesta.setSuccess(false);
			respuesta.setErrorMensaje("Deve Llenar todos Los Campos");
			System.out.println("-----------------------------------------..........................Deve Llenar Todos los campos");
		}
		
		return respuesta;

	}

	@POST
	@Path("deleteUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CommonResponse deleteUsuarios(CommonRequestRoles params) {

		CommonResponse respuesta = new CommonResponse();

		if (LOG.isDebugEnabled()) {
			LOG.debug(".: deleteUser:.");
			LOG.debug(params.getRoldi());
		}

		loginService.eliminarUsuarios(params);
		respuesta.setSuccess(true);
		respuesta.setMensaje("Acceso Permitido");

		return respuesta;

	}

	public LoginServiceImpl getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginServiceImpl loginService) {
		this.loginService = loginService;
	}
	
	
}
