package ar.unlam;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class Vuelo {
	private Integer nroVuelo;
	private String escala;
	private LocalDateTime fechaHora;
	private Avion avion;
	private ArrayList<Personal> personal;
	private ArrayList<Pasajero> pasajeros;
	private ArrayList<Asiento> asientos;

	public Vuelo(Integer nroVuelo, String escala, LocalDateTime fechaHora) {
		this.nroVuelo = nroVuelo;
		this.escala = escala;
		this.fechaHora = fechaHora;
		this.personal = new ArrayList<Personal>();
		this.pasajeros = new ArrayList<Pasajero>();
		this.asientos = new ArrayList<Asiento>();
	}

	
	public ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
	}


	public void setPasajeros(ArrayList<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}


	public ArrayList<Asiento> getAsientos() {
		return asientos;
	}


	public void setAsientos(ArrayList<Asiento> asientos) {
		this.asientos = asientos;
	}


	public ArrayList<Personal> getPersonal() {
		return personal;
	}

	public void setPersonal(ArrayList<Personal> personal) {
		this.personal = personal;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Integer getNroVuelo() {
		return nroVuelo;
	}

	public void setNroVuelo(Integer nroVuelo) {
		this.nroVuelo = nroVuelo;
	}

	public String getEscala() {
		return escala;
	}

	public void setEscala(String escala) {
		this.escala = escala;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public void agregarPersonal(Personal personalEncontrado) {
		this.personal.add(personalEncontrado);
	}

	public Integer obtenerCantidadPersonal() {
		return this.personal.size();
	}
	
	public void seAgregoPasajero(Pasajero pasajero) {
		if(pasajero!=null &&(obtenerCantidadPasajeros()< avion.getCapacidadDeAvion())) {
			agregarPasajero(pasajero);
		}
	}

	public void agregarPasajero(Pasajero pasajero) {
			this.pasajeros.add(pasajero);
		
	}
	
	

	public void agregarAsiento(Asiento asiento) {
		this.asientos.add(asiento);

	}

	public void asignarleUnAsientoAPasajero(Integer idPasajero, Asiento asiento) {
		Pasajero pasajeroEncontrado=buscarPasajeroPorId(idPasajero);
		for (Pasajero pasajeros : pasajeros) {
			if((pasajeroEncontrado!=null) && asiento != null|| (pasajeroEncontrado.getAsiento().equals(asiento))) {
				pasajeroEncontrado.setAsiento(asiento);
			}
			
			
		}
		
	}
	
	public Integer obtenerCantidadPasajeros() {
		return this.pasajeros.size();
	}

	public Pasajero buscarPasajeroPorId(int i) {
		for (Pasajero pasajeros : pasajeros) {
			if(pasajeros.getIdPasajero().equals(i)) {
				return pasajeros;
			}
		}
		return null;
	}

	/*
	 * public void agregarPasajeroId(Integer IdPasajero,Integer IdVuelo) { Pasajero
	 * pasajeroEncontrado=buscarPasajero(IdPasajero); if(pasajeroEncontrado!=null) {
	 * this.agregarPasajero(pasajeroEncontrado); } }
	 * 
	 * private Pasajero buscarPasajero(Integer idPasajero) { for (Pasajero pasajero
	 * : pasajeros) { if(pasajero.getIdPasajero().equals(idPasajero)) { return
	 * pasajero; } } return null; }
	 */

}
