package ar.unlam;

import java.util.ArrayList;

import ar.unlam.aerolinea.Pasaje;

public class Aerolinea {
	private String nombre;
	private ArrayList<Vuelo> vuelos;
	private ArrayList<Personal> personal;
	private ArrayList<Avion> aviones;
	private ArrayList<Pasaje> pasajes;
	private ArrayList<Pasajero> pasajeros;
	private Integer cantidadPasajerosQueNoVolaron = 0;

	public Aerolinea(String nombre) {
		this.nombre = nombre;
		this.vuelos = new ArrayList<>();
		this.personal = new ArrayList<>();
		this.aviones = new ArrayList<>();
	}
	
	public ArrayList<Pasaje> getPasajes() {
		return pasajes;
	}
	
	public void agregarPasaje (Pasaje pasaje){
		this.pasajes.add(pasaje);
	}
	
	public void agregarPasajero(Pasajero pasajero) {
		this.pasajeros.add(pasajero);
	}

	public String getNombre() {
		return this.nombre;
	}

	public void agregarVuelo(Vuelo vuelo) {
		this.vuelos.add(vuelo);

	}

	public Integer getCantidadVuelos() {
		return this.vuelos.size();

	}

	public void agregarPersonal(Personal personal) {
		this.personal.add(personal);

	}

	public Integer obtenerCantidadPersonal() {
		return this.personal.size();
	}

	public Integer obtenerCantidadPersonalPiloto() {
		Integer contador = 0;
		for (Personal personal : personal) {
			if (personal instanceof Piloto) {
				contador++;
			}
		}
		return contador;
	}

	public Integer obtenerCantidadPersonalAzafata() {
		Integer contador = 0;
		for (Personal personal : personal) {
			if (personal instanceof Azafata) {
				contador++;
			}
		}
		return contador;
	}

	public void agregarPersonalAlVuelo(Integer idPersonal, Integer idVuelo) {
		Personal personalEncontrado = buscarPersonal(idPersonal);
		Vuelo vueloEncontrado = buscarVuelo(idVuelo);

		if (personalEncontrado != null && vueloEncontrado != null) {
			if (obtenerCantidadPersonalPiloto() < 2 || obtenerCantidadPersonalAzafata() < 4) {
				vueloEncontrado.agregarPersonal(personalEncontrado);
			}
		}
	}

	// }

	private Vuelo buscarVuelo(Integer idVuelo) {
		for (Vuelo vuelo : vuelos) {
			if (vuelo.getNroVuelo().equals(idVuelo)) {
				return vuelo;
			}

		}
		return null;
	}

	private Personal buscarPersonal(Integer idPersonal) {
		for (Personal personal : personal) {
			if (personal.getId().equals(idPersonal))
				return personal;
		}

		return null;
	}

	public void agregarAvion(Avion avion) {
		this.aviones.add(avion);

	}

	public Integer obtenerCantidadAviones() {
		return this.aviones.size();
	}

	public void asignarAvionAvuelo(Avion avion, Vuelo vuelo) {
		vuelo.setAvion(avion);

	}

	public Boolean queUnPasajeroNoCompreDosPasajesParaElMismoVuelo(Pasajero pasajero, Pasaje pasaje, Vuelo vuelo) {
		Boolean Puede = true;
		Pasajero pasajeroEncontrado = vuelo.buscarPasajeroPorId(pasajero.getIdPasajero());
		Vuelo vueloEncontrado = this.buscarVuelo(vuelo.getNroVuelo());
		if (vueloEncontrado.getNroVuelo().equals(pasaje.getNumeroVuelo())
				&& pasajeroEncontrado.getCantidadPasajes() >= 2) {
			Puede = false;
		}
		return Puede;
	}

	public Pasajero buscarPasajeroPorId(int i) {
		for (Pasajero pasajeros : pasajeros) {
			if (pasajeros.getIdPasajero().equals(i)) {
				return pasajeros;
			}
		}
		return null;
	}

	public Boolean validarQueNoHayaElMismoPasajeroEnElMismoVuelo(Pasaje pasaje) {
		Boolean repetido = false;
		for (Pasaje pasaje1 : pasajes) {
			if(pasaje1.getPasajero().equals(pasaje.getPasajero()) &&
					(pasaje1.getVuelo().equals(pasaje.getVuelo()))){
				repetido = true;
			}
		}
		return repetido;
	}

	public Double descuentoPasajeroVip(Pasajero pasajero, Pasaje pasaje) {
		Double descuento = 0.0;
		if (pasajero.getPasajeroVip() == true) {
			descuento = pasaje.calcularPrecio(pasaje.getPrecio(), pasajero);
			pasajero.setDescuentoVip(descuento);
		}
		return descuento;
	}

	public Boolean validarQueNoHayaDosPasajerosEnElMismoAsiento(Pasajero pasajero, Pasajero pasajero2,
			Asiento asiento) {
		Boolean validacionAsientos = true;
		if (pasajero.getAsiento().getFila().equals(asiento.getFila())
				&& pasajero.getAsiento().getColumna().equals(asiento.getColumna()) == pasajero2.getAsiento().getFila()
						.equals(asiento.getFila())
				&& pasajero2.getAsiento().getColumna().equals(asiento.getColumna())) {
			validacionAsientos = false;

		}
		return validacionAsientos;

	}

	public Boolean agregarAsientoAlVuelo(Asiento asiento, Avion avion, Vuelo vuelo) {
		Boolean sePudoAgregar = false;
		for (Avion avion2 : aviones) {
			if (avion.getSiDespego() == false) {
				vuelo.agregarAsiento(asiento);
				sePudoAgregar = true;
			}

		}

		return sePudoAgregar;

	}

	public ArrayList <Pasajero> obtenerPasajerosQueNoVolaron(Vuelo vuelo) {
	ArrayList <Pasajero> pasajerosQueNoVolaron=new ArrayList<Pasajero>();
	Vuelo vueloEncontrado= this.buscarVuelo(vuelo.getNroVuelo());
	ArrayList <Pasajero> pasajerosEncontrados=  vueloEncontrado.getPasajeros();
		for (Pasajero pasajero : pasajerosEncontrados) {
			if(pasajero.getSiVolo()==false){
				pasajerosQueNoVolaron.add(pasajero);
				this.cantidadPasajerosQueNoVolaron++;
			}
			
		}
		return pasajerosQueNoVolaron;	
	}
	
	public Integer getCantidadPasajerosQueNoVolaron() {
		return cantidadPasajerosQueNoVolaron;
	}
	

	

}
