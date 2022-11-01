package albumDelMundial;

import java.util.Random;

public class Figurita {
	private int numero;
	private String nombreDeJugador;
	
	public Figurita (int numeroRandom) {
		this.numero = numeroRandom;
	}

	public int calcularValorFinal() {
		return 0;
	}

	public static Figurita[] generarFiguritas(int cantidadDeFiguritas) {
		Random random = new Random();
		Figurita[] figuritas = new Figurita[cantidadDeFiguritas];
		
		for (int i = 0; i < cantidadDeFiguritas; i++) {
			figuritas[i] = new Figurita(random.nextInt(350));
		}
		
		return figuritas;
	}
}