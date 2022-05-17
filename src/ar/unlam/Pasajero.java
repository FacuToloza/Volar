package ar.unlam;

import java.util.ArrayList;
import java.util.List;

import ar.unlam.aerolinea.Pasaje;

public class Pasajero {

	private Integer idPasajero;
	private String nombre;
	private String apellido;
	private String pasaporte;
	private Asiento asiento;
	private Pasaje pasajeComprado;
	private List<Pasaje> pasajesComprados = new ArrayList <Pasaje>();
	private Integer cantidadPasajes;
	private Boolean pasajeroVip = false;
	private Double descuentoVip = 0.0;
	private Boolean volo = false;

	public Pasajero(int idPasajero, String nombre, String apellido, String pasaporte) {
		this.idPasajero = idPasajero;
		this.nombre = nombre;
		this.apellido = apellido;
		this.pasaporte = pasaporte;
		this.cantidadPasajes = 0;
		this.getPasajeroVip();
		this.getSiVolo();
	}
	
	public void agregarPasaje(Pasaje pasaje) {
		this.pasajesComprados.add(pasaje);
	}
	
	public Boolean getSiVolo() {
		return volo;
		
	}
	
	public void setVolo(Boolean volo) {
		this.volo = volo;
	}

	public void setCantidadPasajes(){
		cantidadPasajes++;
	}
	
	public Integer getCantidadPasajes(){
		return this.cantidadPasajes;
	}

	
	public Pasaje getPasajeComprado() {
		return pasajeComprado;
	}


	@Override
	public String toString() {
		return "Pasajero [idPasajero=" + idPasajero + ", nombre=" + nombre + ", apellido=" + apellido + ", pasaporte="
				+ pasaporte + ", asiento=" + asiento + "]";
	}


	public Asiento getAsiento() {
		return asiento;
	}


	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}


	public void setIdPasajero(Integer idPasajero) {
		this.idPasajero = idPasajero;
	}


	public Integer getIdPasajero() {
		return idPasajero;
	}

	public void setIdPasajero(int idPasajero) {
		this.idPasajero = idPasajero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}
	
	public void setPasajeComprado(Pasaje pasajeComprado) {
		this.pasajeComprado = pasajeComprado;
	}

	public Boolean getPasajeroVip() {
		return pasajeroVip;
	}

	public void setPasajeroVip() {
		this.pasajeroVip = true;
	}

	public Double getDescuentoVip() {
		return descuentoVip;
	}

	public void setDescuentoVip(Double descuentoVip) {
		this.descuentoVip = descuentoVip;
	}

	public List<Pasaje> getPasajesComprados() {
		return pasajesComprados;
	}

	public void setPasajesComprados(List<Pasaje> pasajesComprados) {
		this.pasajesComprados = pasajesComprados;
	}


	


	
	
	

}
