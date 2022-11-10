package albumDelMundial;

import java.util.List;
import java.util.Random;

public class Figurita {
	private int numero;

	private String nombreDeJugador;
	private String paisAnfitrion = "Qatar";
	private int valorBase;
	
	enum TipoDeFigurita {
		Top10,
		Tradicional
	}
	
	public Figurita (int numeroRandom) {
		this.numero = numeroRandom;
		this.nombreDeJugador = "Jugador " + numeroRandom;
	}

	public int calcularValorFinal() {		
		
		return valorBase + Fabrica.getRanking().get(pais);
	}

	public static List<Figurita> generarFiguritas(int cantidadDeFiguritas, TipoDeFigurita tipo) {
		Random random = new Random();
		List<Figurita> figuritas = null;
		
		if (tipo == TipoDeFigurita.Top10)
			figuritas = Fabrica.solicitudAFabrica.generarSobre(cantidadDeFiguritas);
		else 
			figuritas = Fabrica.solicitudAFabrica.generarSobreTop10(cantidadDeFiguritas);
	
		return figuritas;
	}
	
	public int getNumero() {
		return numero;
	}
}