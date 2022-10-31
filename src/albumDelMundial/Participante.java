package albumDelMundial;

import java.util.HashSet;

public class Participante {
	private int dni;
	private String nombreDeUsuario;
	private HashSet<Figurita> figuritasObtenidas;
	private HashSet<Figurita> figuritasRepetidas;
	private Album albumComprado;
	
	public Participante(int dni, String nombreDeUsuario, String tipoDeAlbum) {
		Fabrica fabrica = new Fabrica();
		this.dni = dni;
		this.nombreDeUsuario = nombreDeUsuario;
		
		Album albumElegido;
		
		switch (tipoDeAlbum) {
		 case "Tradicional":
			 albumElegido = fabrica.crearAlbumTradicional();
		 case "Extendido":
			 albumElegido = fabrica.crearAlbumExtendido();
		 case "Web":
			 albumElegido = fabrica.crearAlbumWeb();
		}
		
		this.albumComprado = albumElegido;
	}
	
	public int obtenerCodigoDeAlbum() {
		return this.albumComprado.obtenerCodigo();
	}
}
