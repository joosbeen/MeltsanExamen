package com.mts.login.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.mts.domain.CommonRequest;
import com.mts.domain.CommonRequestRoles;
import com.mts.domain.Jdbc;
import com.mts.login.vo.PantallasVO;
import com.mts.login.vo.RolVO;
import com.mts.login.vo.RolesVO;
import com.mts.login.vo.UserVO;

/* 3
 * Se implementa en la clase LoginDaoImpl.java
 * haciendo un implements de la interface LoginDao.java,
 * para implementar cada método de la interface.
*/

public class LoginDaoImpl extends Jdbc implements LoginDao {

	private String qryRoles;
	private String qryPantalllas;
	private String qryListaRoles;
	private String qryInsertarRoles;
	private String qryActualizarRoles;
	private String qryEliminarRoles;

	@Override
	public List<RolesVO> roles() {
		List<RolesVO> result = this.jdbcTemplate.query(qryRoles, ROLES_MAPPER);
		return result;

	}

	@Override
	public void insertUsuarios(CommonRequestRoles params) {
		this.jdbcTemplate.update(qryInsertarRoles,

				new Object[] { params.getRol(), params.getVigencia(), params.getDsrol(), params.getSwanalista() });

	}
	
	@Override
	public void actualizarUsuarios(CommonRequestRoles params) { 
		
		this.jdbcTemplate.update(qryActualizarRoles, 
				new Object[] { 
						params.getVigencia(), 
						params.getActualizado_por(), 
						params.getDsrol(), 
						params.getSwanalista(), 
						params.getRoldi() });

	}
	
	@Override
	public void eliminarUsuarios(CommonRequestRoles params) { 
		
		this.jdbcTemplate.update(qryEliminarRoles, 
				new Object[] {
						params.getRoldi()
						});
//		String sql = "UPDATE MTS_SEG_ROLES SET SW_ANALISTA = 'N' WHERE ROLID = "+params.getRoldi();
//		this.jdbcTemplate.update(sql);

	}

	@Override
	public List<PantallasVO> pantallas() {
		List<PantallasVO> result = this.jdbcTemplate.query(qryPantalllas, PANTALLAS_MAPPER);
		return result;

	}

	@Override
	public List<RolVO> rol() {
		List<RolVO> result = this.jdbcTemplate.query(qryListaRoles, LsitROLES_MAPPER);
		return result;

	}

	private static final RowMapper<PantallasVO> PANTALLAS_MAPPER = new RowMapper<PantallasVO>() {
		@Override
		public PantallasVO mapRow(ResultSet rs, int num) throws SQLException {
			PantallasVO result = new PantallasVO();

			result.setDsUrl(rs.getString("DS_URL"));
			result.setMenu(rs.getString("MENU"));
			result.setPantalla(rs.getString("PANTALLA"));
			result.setPantallaId(rs.getString("PANTALLAID"));
			return result;
		}
	};
	private static final RowMapper<RolVO> LsitROLES_MAPPER = new RowMapper<RolVO>() {
		@Override
		public RolVO mapRow(ResultSet rs, int num) throws SQLException {
			RolVO result = new RolVO();

			result.setRoldi(rs.getString("ROLID"));
			result.setRol(rs.getString("ROL"));
			result.setVigencia(rs.getString("VIGENCIA"));
			result.setCreado_pro(rs.getString("CREADO_POR"));
			result.setFec_creacion(rs.getString("FEC_CREACION"));
			result.setActualizado_por(rs.getString("ACTUALIZADO_POR"));
			result.setSwanalista(rs.getString("SW_ANALISTA"));
			result.setDsrol(rs.getString("DS_ROL"));
			return result;
		}
	};

	private static final RowMapper<RolesVO> ROLES_MAPPER = new RowMapper<RolesVO>() {
		@Override
		public RolesVO mapRow(ResultSet rs, int num) throws SQLException {
			RolesVO result = new RolesVO();

			result.setRolId(rs.getString("ROLID"));
			result.setDsRol(rs.getString("ROL"));
			return result;
		}
	};

	public String getQryRoles() {
		return qryRoles;
	}

	public void setQryRoles(String qryRoles) {
		this.qryRoles = qryRoles;
	}

	public String getQryPantalllas() {
		return qryPantalllas;
	}

	public void setQryPantalllas(String qryPantalllas) {
		this.qryPantalllas = qryPantalllas;
	}

	public String getQryActualizarRoles() {
		return qryActualizarRoles;
	}

	public void setQryActualizarRoles(String qryActualizarRoles) {
		this.qryActualizarRoles = qryActualizarRoles;
	}

	public String getQryListaRoles() {
		return qryListaRoles;
	}

	public void setQryListaRoles(String qryListaRoles) {
		this.qryListaRoles = qryListaRoles;
	}

	public String getQryInsertarRoles() {
		return qryInsertarRoles;
	}

	public void setQryInsertarRoles(String qryInsertarRoles) {
		this.qryInsertarRoles = qryInsertarRoles;
	}

	public String getQryEliminarRoles() {
		return qryEliminarRoles;
	}

	public void setQryEliminarRoles(String qryEliminarRoles) {
		this.qryEliminarRoles = qryEliminarRoles;
	}
	
	

}
