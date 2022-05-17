package ar.unlam.aerolinea;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;

import ar.unlam.Aerolinea;
import ar.unlam.Asiento;
import ar.unlam.Avion;
import ar.unlam.Azafata;
import ar.unlam.Pasajero;
import ar.unlam.Personal;
import ar.unlam.Piloto;
import ar.unlam.Vuelo;

public class TestAeolinea {

	@Test
	public void queSePuedaCrearUnaAerolinea() {

		Aerolinea aerolinea = new Aerolinea("Argentinas");
		String esperado = "Argentinas";
		String resultado = aerolinea.getNombre();
		assertEquals(esperado, resultado);

	}

	@Test
	public void crearVueloEnUnaAerolinea() {
		Aerolinea aerolinea = new Aerolinea("Argentinas");
		LocalDateTime fechaHora = LocalDateTime.of(2022, Month.JUNE, 07, 20, 30);
		Vuelo vuelo = new Vuelo(001, "Bariloche", fechaHora);

		aerolinea.agregarVuelo(vuelo);
		Integer valorEsperado = 1;
		Integer valorObtenido = aerolinea.getCantidadVuelos();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void agregarPilotoAUnaAerolinea() {
		Aerolinea aerolinea = new Aerolinea("Argentinas");

		Personal personal = new Piloto(1, "Harry", "Styles");
		aerolinea.agregarPersonal(personal);

		Integer resultadoEsperado = 1;
		Integer resultadoObtenido = aerolinea.obtenerCantidadPersonal();
		assertEquals(resultadoEsperado, resultadoObtenido);

	}

	@Test
	public void agregarPilotoAVuelo() {
		Aerolinea aerolinea = new Aerolinea("Argentinas");

		Personal personal = new Piloto(1, "Harry", "Styles");
		aerolinea.agregarPersonal(personal);

		Vuelo vuelo = new Vuelo(001, "Bariloche", LocalDateTime.now());
		aerolinea.agregarVuelo(vuelo);

		Integer idPiloto = 1;
		Integer idVuelo = 001;

		aerolinea.agregarPersonalAlVuelo(idPiloto, idVuelo);

		assertEquals(idPiloto, personal.getId());
		assertEquals(idVuelo, vuelo.getNroVuelo());

	}

	@Test
	public void agregarAzafataAlVuelo() {
		Aerolinea aerolinea = new Aerolinea("Argentinas");

		Personal personal = new Azafata(2, "Miley", "Cyrus");
		aerolinea.agregarPersonal(personal);

		Vuelo vuelo = new Vuelo(001, "Bariloche", LocalDateTime.now());
		aerolinea.agregarVuelo(vuelo);

		Integer idAzafata = 2;
		Integer idVuelo = 001;

		aerolinea.agregarPersonalAlVuelo(idAzafata, idVuelo);

		assertEquals(idAzafata, personal.getId());
		assertEquals(idVuelo, vuelo.getNroVuelo());

	}

	@Test(expected = Error.class)
	public void queNoSePuedanAgregarMasDeDosPiltosAUnVuelo() {
		Aerolinea aerolinea = new Aerolinea("Argentinas");

		Personal personal = new Piloto(1, "Harry", "Styles");
		aerolinea.agregarPersonal(personal);

		Personal personal2 = new Piloto(2, "Britney", "Spears");
		aerolinea.agregarPersonal(personal2);

		Personal personal3 = new Piloto(3, "Rihanna", "a");
		aerolinea.agregarPersonal(personal3);

		Vuelo vuelo = new Vuelo(001, "Bariloche", LocalDateTime.now());
		aerolinea.agregarVuelo(vuelo);

		aerolinea.agregarPersonalAlVuelo(1, 001);
		aerolinea.agregarPersonalAlVuelo(2, 001);
		aerolinea.agregarPersonalAlVuelo(3, 001);

		Integer resultadoEsperado = 2;
		assertEquals(resultadoEsperado, aerolinea.obtenerCantidadPersonalPiloto());

	}

	@Test(expected = Error.class)
	public void queNoSePuedanAgregarMasDe4AzafatasAUnVuelo() {
		Aerolinea aerolinea = new Aerolinea("Argentinas");
		Personal piloto = new Piloto(2, "Harry", "Styles");
		aerolinea.agregarPersonal(piloto);

		Personal personal = new Azafata(4, "Miley", "Cyrus");
		aerolinea.agregarPersonal(personal);

		Personal personal2 = new Azafata(5, "Hannah", "Montana");
		aerolinea.agregarPersonal(personal2);

		Personal personal3 = new Azafata(6, "Nathy", "Pelusso");
		aerolinea.agregarPersonal(personal3);

		Personal personal4 = new Azafata(7, "Lali", "Esposito");
		aerolinea.agregarPersonal(personal4);

		Personal personal5 = new Azafata(8, "Katy", "Perry");
		aerolinea.agregarPersonal(personal5);

		Vuelo vuelo = new Vuelo(001, "Bariloche", LocalDateTime.now());
		aerolinea.agregarVuelo(vuelo);

		aerolinea.agregarPersonalAlVuelo(4, 001);
		aerolinea.agregarPersonalAlVuelo(5, 001);
		aerolinea.agregarPersonalAlVuelo(6, 001);
		aerolinea.agregarPersonalAlVuelo(7, 001);
		aerolinea.agregarPersonalAlVuelo(8, 001);
		aerolinea.agregarPersonalAlVuelo(2, 001);

		Integer resultadoEsperado = 4;
		assertEquals(resultadoEsperado, aerolinea.obtenerCantidadPersonalAzafata());

	}

	@Test
	public void crearUnAvionEnUnaAerolinea() {
		Aerolinea aerolinea = new Aerolinea("Argentinas");

		Avion avion = new Avion(01, "Boeing 747", "Boeing");
		aerolinea.agregarAvion(avion);

		Integer esperado = 1;
		assertEquals(esperado, aerolinea.obtenerCantidadAviones());

	}

	@Test
	public void asignarUnAvionAUnVuelo() {
		Aerolinea aerolinea = new Aerolinea("Argentinas");

		Avion avion = new Avion(01, "Boeing 747", "Boeing");
		aerolinea.agregarAvion(avion);

		Vuelo vuelo = new Vuelo(001, "Bariloche", LocalDateTime.now());
		aerolinea.agregarVuelo(vuelo);

		aerolinea.asignarAvionAvuelo(avion, vuelo);

		assertEquals(avion, vuelo.getAvion());

	}

	@Test
	public void asignarPasajeroAUnVuelo() {
		Aerolinea aerolinea = new Aerolinea("Argentinas");

		Vuelo vuelo = new Vuelo(001, "Bariloche", LocalDateTime.now());
		aerolinea.agregarVuelo(vuelo);

		Pasajero pasajero = new Pasajero(1, "Flor", "Santamaría", "AAA111222");
		vuelo.agregarPasajero(pasajero);

		Integer esperado = 1;
		assertEquals(esperado, pasajero.getIdPasajero());

	}

	@Test
	public void asignarAsientoAPasajero() {
		Aerolinea aerolinea = new Aerolinea("Argentinas");

		Vuelo vuelo = new Vuelo(001, "Bariloche", LocalDateTime.now());
		aerolinea.agregarVuelo(vuelo);

		Avion avion = new Avion(01, "Boeing 747", "Boeing");
		aerolinea.agregarAvion(avion);

		Pasajero pasajero = new Pasajero(1, "Flor", "Santamaría", "AAA111222");
		vuelo.agregarPasajero(pasajero);

		Pasajero pasajero2 = new Pasajero(2, "Flor", "Santamarta", "AAA111333");
		vuelo.agregarPasajero(pasajero2);

		Asiento asiento = new Asiento("A", "1");
		avion.agregarAsiento(asiento);
		Asiento asiento2 = new Asiento("A", "2");
		avion.agregarAsiento(asiento);

		vuelo.asignarleUnAsientoAPasajero(1, asiento);
		vuelo.asignarleUnAsientoAPasajero(2, asiento2);
		assertEquals(asiento, pasajero.getAsiento());
		assertEquals(asiento2, pasajero2.getAsiento());

	}

	@Test
	public void queNoSePuedaAsignarUnAsientoAunPasajeroSiElAsientoEstaOcupado() {
		Aerolinea aerolinea = new Aerolinea("Argentinas");

		Vuelo vuelo = new Vuelo(001, "Bariloche", LocalDateTime.now());
		aerolinea.agregarVuelo(vuelo);

		Avion avion = new Avion(01, "Boeing 747", "Boeing");
		aerolinea.agregarAvion(avion);

		Pasajero pasajero = new Pasajero(1, "Flor", "Santamaría", "AAA111222");
		vuelo.agregarPasajero(pasajero);
		Pasajero pasajero2 = new Pasajero(2, "Flor", "Santamarta", "AAA111333");
		vuelo.agregarPasajero(pasajero2);
		Asiento asiento = new Asiento("A", "1");
		avion.agregarAsiento(asiento);

		vuelo.asignarleUnAsientoAPasajero(1, asiento);
		vuelo.asignarleUnAsientoAPasajero(2, asiento);

		Boolean resultado = aerolinea.validarQueNoHayaDosPasajerosEnElMismoAsiento(pasajero, pasajero2, asiento);
		assertFalse(resultado);
	}

	@Test // (expected = Error.class)
	public void queNoSePuedanAgregarMasPasajerosQueLaCapacidadDelAvion() {
		Aerolinea aerolinea = new Aerolinea("Argentinas");

		Avion avion = new Avion(01, "Boeing 747", "Boeing");
		aerolinea.agregarAvion(avion);
		Vuelo vuelo = new Vuelo(001, "Bariloche", LocalDateTime.now());
		aerolinea.agregarVuelo(vuelo);

		aerolinea.asignarAvionAvuelo(avion, vuelo);

		Pasajero pasajero = new Pasajero(1, "Flor", "Santamaría", "AAA111222");
		vuelo.seAgregoPasajero(pasajero);

		Pasajero pasajero2 = new Pasajero(2, "Flor", "Santamarta", "AAA111333");
		vuelo.seAgregoPasajero(pasajero2);

		Pasajero pasajero3 = new Pasajero(1, "Flor", "Santamaría", "AAA111222");
		vuelo.seAgregoPasajero(pasajero3);

		Pasajero pasajero4 = new Pasajero(2, "Flor", "Santamarta", "AAA111333");
		vuelo.seAgregoPasajero(pasajero4);
		Pasajero pasajero5 = new Pasajero(2, "Flor", "Santamarta", "AAA111333");
		vuelo.seAgregoPasajero(pasajero4);

		Integer esperado = 3;
		assertEquals(esperado, vuelo.obtenerCantidadPasajeros());
		System.out.println(vuelo.obtenerCantidadPasajeros());

	}

	@Test
	public void queSePuedaComprarUnPasajeParaUnPasajero() {
		Aerolinea aerolinea = new Aerolinea("Argentinas");

		Pasajero pasajero = new Pasajero(1, "Flor", "Santamaría", "AAA111222");

		Integer idPasaje = 1;
		Double precio = 30000.0;

		Vuelo vuelo = new Vuelo(001, "Bariloche", LocalDateTime.now());
		aerolinea.agregarVuelo(vuelo);

		Pasaje pasaje = new Pasaje(idPasaje, precio, pasajero, vuelo);

		pasajero.setPasajeComprado(pasaje);
		Integer pasajeComprado = pasajero.getPasajeComprado().getIdPasaje();

		Integer resultadoEsperado = 1;

		assertEquals(resultadoEsperado, pasajeComprado);
	}

	@Test
	public void queNoSePuedanComprar2PasajesParaElMismoPasajeroYVuelo() {

		Aerolinea aerolinea = new Aerolinea("Argentinas");

		Pasajero pasajero = new Pasajero(1, "Flor", "Santamaría", "AAA111222");

		Vuelo vuelo = new Vuelo(001, "Bariloche", LocalDateTime.now());
		Pasaje pasaje = new Pasaje(1, 40000.0, pasajero, vuelo);
		
		aerolinea.agregarPasaje(pasaje);
		aerolinea.agregarPasaje(pasaje);
		
		
		Boolean resultado = aerolinea.validarQueNoHayaElMismoPasajeroEnElMismoVuelo(pasaje);
		
		
		assertTrue(resultado);

	}

	@Test
	public void pasajeroVip() {
		Aerolinea aerolinea = new Aerolinea("Argentinas");
		Pasajero pasajero = new Pasajero(1, "Flor", "Santamaría", "AAA111222");
		Vuelo vuelo = new Vuelo(001, "Bariloche", LocalDateTime.now());
		Pasaje pasaje = new Pasaje(1, 40000.0, pasajero, vuelo);
		pasajero.setPasajeroVip();
		Double resultado = pasaje.calcularPrecio(40000.0, pasajero);
		Double resultadoEsperado = 2000.0;

		assertEquals(resultadoEsperado, resultado);

		System.out.println(resultado);
	}

	@Test
	public void queNoSePuedaAsignarUnAsientoSiElAvionYaDespego() {
		Aerolinea aerolinea = new Aerolinea("Argentinas");

		Vuelo vuelo = new Vuelo(001, "Bariloche", LocalDateTime.now());
		aerolinea.agregarVuelo(vuelo);

		Avion avion = new Avion(01, "Boeing 747", "Boeing");
		aerolinea.agregarAvion(avion);
		
		Asiento asiento=new Asiento("A","1");
		avion.setDespego(true);
		Boolean resultado= aerolinea.agregarAsientoAlVuelo(asiento, avion,vuelo);
		
		
		assertFalse(resultado);
		

	}
	
	@Test
	public void queSePuedaObtenerListaDePasajerosQueNoVolaron(){
		Aerolinea aerolinea = new Aerolinea("Argentinas");
		Pasajero pasajero = new Pasajero(1, "Flor", "Santamaría", "AAA111222");
		Pasajero pasajero2 = new Pasajero(2, "Jaz", "De Stefano", "AAA111222");
		Pasajero pasajero3 = new Pasajero(3, "Flor", "Santamaría", "AAA111222");
		Pasajero pasajero4 = new Pasajero(4, "Flor", "Santamaría", "AAA111222");
		Vuelo vuelo = new Vuelo(001, "Bariloche", LocalDateTime.now());
		aerolinea.agregarVuelo(vuelo);
		
		pasajero2.setVolo(true);
		pasajero3.setVolo(true);
		vuelo.agregarPasajero(pasajero4);
		vuelo.agregarPasajero(pasajero3);
		vuelo.agregarPasajero(pasajero2);
		vuelo.agregarPasajero(pasajero);
		
		aerolinea.obtenerPasajerosQueNoVolaron(vuelo);
		Integer resultado = aerolinea.getCantidadPasajerosQueNoVolaron();
		Integer resultadoEsperado = 2;
		
		assertEquals(resultadoEsperado, resultado);
		
		
	}

}
