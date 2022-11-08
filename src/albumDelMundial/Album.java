package albumDelMundial;

import java.util.HashSet;

public class Album {
	private int codigo;
	private String nombreDeUsuario;
	private HashSet<Figurita> figuritasPegadas;
	
	public Album(String nombreDeUsuario, int codigo) {
		this.nombreDeUsuario = nombreDeUsuario;
		this.codigo = codigo;
	}
	
	private static int TOTAL_DE_FIGURITAS_PARA_PEGAR = 320;
	
	public int obtenerCodigo() {
		return codigo;
	}

	public boolean estoyCompletado() {
		return (figuritasPegadas.size() == TOTAL_DE_FIGURITAS_PARA_PEGAR);
	}
	
	public boolean completoPais() {
		return false;
	}
	
	public static Album obtenerAlbumPorSuTipo (String tipoDeAlbum) {
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
}
