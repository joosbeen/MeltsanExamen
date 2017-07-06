package com.mts.domain;

public class CommonRequestRoles {

	private String roldi;
	private String rol;
	private String vigencia;
	private String creado_pro;
	private String fec_creacion;
	private String fec_actualizacion;
	private String actualizado_por;
	private String dsrol;
	private String swanalista;

	public CommonRequestRoles() {

	}

	public CommonRequestRoles(String roldi, String rol, String vigencia, String creado_pro, String fec_creacion,
			String fec_actualizacion, String actualizado_por, String dsrol, String swanalista) {
		super();
		this.roldi = roldi;
		this.rol = rol;
		this.vigencia = vigencia;
		this.creado_pro = creado_pro;
		this.fec_creacion = fec_creacion;
		this.fec_actualizacion = fec_actualizacion;
		this.actualizado_por = actualizado_por;
		this.dsrol = dsrol;
		this.swanalista = swanalista;
	}

	public String getRoldi() {
		return roldi;
	}

	public void setRoldi(String roldi) {
		this.roldi = roldi;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getVigencia() {
		return vigencia;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}

	public String getCreado_pro() {
		return creado_pro;
	}

	public void setCreado_pro(String creado_pro) {
		this.creado_pro = creado_pro;
	}

	public String getFec_creacion() {
		return fec_creacion;
	}

	public void setFec_creacion(String fec_creacion) {
		this.fec_creacion = fec_creacion;
	}

	public String getFec_actualizacion() {
		return fec_actualizacion;
	}

	public void setFec_actualizacion(String fec_actualizacion) {
		this.fec_actualizacion = fec_actualizacion;
	}

	public String getActualizado_por() {
		return actualizado_por;
	}

	public void setActualizado_por(String actualizado_por) {
		this.actualizado_por = actualizado_por;
	}

	public String getDsrol() {
		return dsrol;
	}

	public void setDsrol(String dsrol) {
		this.dsrol = dsrol;
	}

	public String getSwanalista() {
		return swanalista;
	}

	public void setSwanalista(String swanalista) {
		this.swanalista = swanalista;
	}

}
