package com.mts.login.service;

import java.util.List;

import com.mts.domain.CommonRequest;
import com.mts.domain.CommonRequestRoles;
import com.mts.login.vo.PantallasVO;
import com.mts.login.vo.RolVO;
import com.mts.login.vo.RolesVO;

// 2
//Se crea el acceso a los datos a trav�s
//de una interface,
//aqu� se declara todos los m�todos 
//para acceder a los datos.

public interface LoginService {

	List<PantallasVO> pantallas();
	List<RolesVO> roles();
	List<RolVO> rol();
	void insertUsuarios(CommonRequestRoles params);
	void actualizarUsuarios(CommonRequestRoles params);
	void eliminarUsuarios(CommonRequestRoles params); 

}
