package albumDelMundial;

import java.util.List;
import java.util.Random;

public class Figurita {
	private int numero;
	private String nombreDeJugador;
	private String paisAnfitrion = "Qatar";
	
	enum TipoDeFigurita {
		Top10,
		Tradicional
	}
	
	public Figurita (int numeroRandom) {
		this.numero = numeroRandom;
		this.nombreDeJugador = "Jugador" + numeroRandom;
	}

	public int calcularValorFinal() {
		return 0;
	}

	public static List<Figurita> generarFiguritas(int cantidadDeFiguritas, TipoDeFigurita tipo) {
		Random random = new Random();
		Fabrica fabrica = Fabrica.visitarFabrica();
		List<Figurita> figuritas = null;
		
		if (tipo == TipoDeFigurita.Top10)
			figuritas = fabrica.generarSobre(cantidadDeFiguritas);
		else 
			figuritas = fabrica.generarSobreTop10(cantidadDeFiguritas);
	
		return figuritas;
	}
}