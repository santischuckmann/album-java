package albumDelMundial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Participante {
	private int dni;
	private String nombreDeUsuario;
	private HashSet<Figurita> figuritasObtenidas;
	private ArrayList<Figurita> figuritasRepetidas;
	private Album albumComprado;
	private String tipoDeAlbumComprado;
	private boolean codigoPromocionalUtilizado;
	

	public Participante(int dni, String nombreDeUsuario, String tipoDeAlbum) {
		this.dni = dni;
		this.nombreDeUsuario = nombreDeUsuario;

		this.albumComprado = Album.obtenerAlbumPorSuTipo(tipoDeAlbum);
		
		this.tipoDeAlbumComprado = tipoDeAlbum;
		this.codigoPromocionalUtilizado = false;
	}
	
	public int obtenerCodigoDeAlbum() {
		return this.albumComprado.obtenerCodigo();
	}
	
	public void recibirFiguritas (List<Figurita> figuritas) {
		for (Figurita figurita : figuritas) {
			if (!figuritasObtenidas.contains(figurita))
				figuritasObtenidas.add(figurita);			
			figuritasRepetidas.add(figurita);
		}
	}
	
	public int getDni() {
		return dni;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}
	
	public String obtenerTipoDeAlbumComprado() { 
		return tipoDeAlbumComprado;
	}

	public HashSet<Figurita> getFiguritasObtenidas() {
		return figuritasObtenidas;
	}

	public ArrayList<Figurita> getFiguritasRepetidas() {
		return figuritasRepetidas;
	}

	public Album getAlbumComprado() {
		return albumComprado;
	}

	public boolean completoAlbum() {
		return this.albumComprado.estoyCompletado();
	}
	public boolean getCodigoPromocionalUtilizado() {
		return codigoPromocionalUtilizado;
	}
	public void setCodigoPromocionalUtilizado(boolean codigoPromocionalUtilizado) {
		this.codigoPromocionalUtilizado = codigoPromocionalUtilizado;
	}

	public boolean compararObtenidasConFiguritasEnSuAlbum() {		
		if (figuritasObtenidas.size() != albumComprado.getfiguritasYaPegadas().size() - 1) {
			return true;
		}
		return false;			
	}
	
	
}
