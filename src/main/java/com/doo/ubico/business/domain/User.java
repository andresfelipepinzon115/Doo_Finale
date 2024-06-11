package com.doo.ubico.business.domain;

public class User {
	private String id;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String numeroDocumento;
	private TipoDocumento tipoDocumento;
	private String correoElectronico;
	private String telefonoMovil;
	private String password;

	// Constructors, getters, and setters

	public User() {
	}

	public User(String id, String nombre, String primerApellido, String segundoApellido, String numeroDocumento,
			TipoDocumento tipoDocumento, String correoElectronico, String telefonoMovil, String password) {
		this.id = id;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.numeroDocumento = numeroDocumento;
		this.tipoDocumento = tipoDocumento;
		this.correoElectronico = correoElectronico;
		this.telefonoMovil = telefonoMovil;
		this.password = password;
	}
	
	public User(String id, String nombre, String email, String password) {
		this.id = id;
		this.nombre = nombre;
		this.correoElectronico = email;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public String getPassword() {
		return password;
	}

	public void setId(String id) {
		this.id = id;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	private void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	private void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	private void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	private void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	private void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	private void setPassword(String password) {
		this.password = password;
	}

}
