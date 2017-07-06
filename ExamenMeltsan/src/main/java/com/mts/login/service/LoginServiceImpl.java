package com.mts.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mts.domain.CommonRequestRoles;
import com.mts.login.dao.LoginDao;
import com.mts.login.vo.PantallasVO;
import com.mts.login.vo.RolVO;
import com.mts.login.vo.RolesVO;

@Service
public class LoginServiceImpl implements LoginService {
	
	
	@Autowired
	private LoginDao loginDao;
	
	
	@Override
	  public List<RolesVO> roles(){
		return loginDao.roles();
	   }
	
	
	@Override
	  public List<PantallasVO> pantallas(){
		return loginDao.pantallas();
	   }
	
	@Override
	  public List<RolVO> rol(){
		return loginDao.rol();
	   }
	
	@Override
	public void insertUsuarios(CommonRequestRoles params) {
		loginDao.insertUsuarios(params);
	}
	
	@Override
	public void actualizarUsuarios(CommonRequestRoles params) { 
		loginDao.actualizarUsuarios(params);
	}
	
	@Override
	public void eliminarUsuarios(CommonRequestRoles params) { 
		loginDao.eliminarUsuarios(params);
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	
	
	

}
