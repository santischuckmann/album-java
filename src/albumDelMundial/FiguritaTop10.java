package albumDelMundial;

import albumDelMundial.Fabrica.TipoDeBalon;

public class FiguritaTop10 extends Figurita {
	private TipoDeBalon balonGanado;
	
	public FiguritaTop10 (int numeroRandom, TipoDeBalon balonGanado) {
		super(numeroRandom);
		
		this.balonGanado = balonGanado; 
	}
}
