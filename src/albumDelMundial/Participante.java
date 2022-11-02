package albumDelMundial;

import java.util.ArrayList;
import java.util.HashSet;

public class Participante {
	private int dni;
	private String nombreDeUsuario;
	private HashSet<Figurita> figuritasObtenidas;
	private ArrayList<Figurita> figuritasRepetidas;
	private Album albumComprado;
	
	public Participante(int dni, String nombreDeUsuario, String tipoDeAlbum) {
		this.dni = dni;
		this.nombreDeUsuario = nombreDeUsuario;

		this.albumComprado = registrarTipoDeAlbum(tipoDeAlbum);
	}
	
	public int obtenerCodigoDeAlbum() {
		return this.albumComprado.obtenerCodigo();
	}
	
	private Album registrarTipoDeAlbum (String tipoDeAlbum) {
		Fabrica fabrica = Fabrica.visitarFabrica();
		Album albumElegido = null;
		
		switch (tipoDeAlbum) {
		 case "Tradicional":
			 albumElegido = fabrica.crearAlbumTradicional();
		 case "Extendido":
			 albumElegido = fabrica.crearAlbumExtendido();
		 case "Web":
			 albumElegido = fabrica.crearAlbumWeb();
		}
		
		if (albumElegido == null)
			throw new RuntimeException("El tipo de album brindado no es valido");
		
		return albumElegido;
		
	}
	
	public void recibirFiguritas (Figurita[] figuritas) {
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
}
