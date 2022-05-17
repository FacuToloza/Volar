package ar.unlam;

import java.util.ArrayList;

public class Avion {
	
	private Integer id;
	private String modelo;
	private String fabricante;
	private Integer capacidadDeAvion;
	private ArrayList<Asiento>asientos;
	private Boolean despego;
	
	public Avion(Integer id, String modelo, String fabricante) {
		this.id = id;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.capacidadDeAvion=3;
		this.asientos=new ArrayList<Asiento>();
		this.getSiDespego();
	}

	
	public Boolean getSiDespego() {
		return this.despego;
		
	}
	
	public void setDespego(Boolean despego) {
		this.despego = despego;
	}
	


	public ArrayList<Asiento> getAsientos() {
		return asientos;
	}
	
	public Integer obtenerCantidadAsientos() {
		return this.asientos.size();
	}


	public void setAsientos(ArrayList<Asiento> asientos) {
		this.asientos = asientos;
	}


	public Integer getCapacidadDeAvion() {
		return capacidadDeAvion;
	}


	public void setCapacidadDeAvion(Integer capacidadDeAvion) {
		this.capacidadDeAvion = capacidadDeAvion;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Avion [id=" + id + ", modelo=" + modelo + ", fabricante=" + fabricante + "]";
	}


	public void agregarAsiento(Asiento asiento) {
		this.asientos.add(asiento);
		
	}

	
	

}
