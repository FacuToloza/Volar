package ar.unlam;

public class Asiento {
	
	private String fila;
	private String columna;
	
	public Asiento(String fila, String columna) {
		this.fila = fila;
		this.columna = columna;
	}

	public String getFila() {
		return fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}

	public String getColumna() {
		return columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}

	@Override
	public String toString() {
		return "Asiento [fila=" + fila + ", columna=" + columna + "]";
	}
	
	
	
	
	
	

}
