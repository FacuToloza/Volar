package ar.unlam.aerolinea;

import ar.unlam.Pasajero;
import ar.unlam.Vuelo;

public class Pasaje {
	private Integer idPasaje;
	private Double precio;
	private Vuelo vuelo;
	private Pasajero pasajero;
	private Integer numeroVuelo;

	public Pasaje(Integer idPasaje, Double precio,Pasajero pasajero, Vuelo vuelo) {
		this.idPasaje=idPasaje;
		this.precio=calcularPrecio(precio, pasajero);
		this.setPasajero(pasajero);
		this.setVuelo(vuelo);

	}

	public Double calcularPrecio(Double monto, Pasajero pasajero2) {
		Double descuento = 0.0;
		if(pasajero2.getPasajeroVip() == true){
			descuento = (5 * monto) / 100;
		}
		return descuento;
	}

	private void setNumeroVuelo(Integer numeroVuelo2) {
		this.numeroVuelo = numeroVuelo2;
	}
	
	public Integer getNumeroVuelo() {
		return this.numeroVuelo;
	}

	public Integer getIdPasaje() {
		return idPasaje;
	}

	public void setIdPasaje(Integer idPasaje) {
		this.idPasaje = idPasaje;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Pasaje [idPasaje=" + idPasaje + ", precio=" + precio + "]";
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	
	

}
