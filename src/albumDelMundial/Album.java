package albumDelMundial;

import java.util.HashSet;

public class Album {
	private int codigo;
	private String nombreDeUsuario;
	private HashSet<Figurita> figuritasPegadas;
	
	private static int TOTAL_DE_FIGURITAS_PARA_PEGAR = 320;
	
	public int obtenerCodigo() {
		return codigo;
	}

	public boolean estoyCompletado() {
		return (figuritasPegadas.size() == TOTAL_DE_FIGURITAS_PARA_PEGAR);
	}
}
