package albumDelMundial;

import java.util.ArrayList;
import java.util.List;

import albumDelMundial.Figurita.TipoDeFigurita;

public class AlbumDelMundial implements IAlbumDelMundial{
	private ArrayList<Participante> participantes;
	
	public AlbumDelMundial() {
		this.participantes = new ArrayList<Participante>();
	}
	
	private void verificarParticipanteRegistrado(int dni) {
		Participante participante = obtenerParticipanteConDni(dni);
		
		if (participante == null)
			throw new RuntimeException("El participante no esta registrado en el sistema");
	}
	
	private Participante obtenerParticipanteConDni(int dni) {
		Participante participante = null;
		
		for (Participante p : participantes) {
			if (dni == p.getDni())
				participante = p;
		}
		
		return participante;
	}
	
	@Override
	public int registrarParticipante(int dni, String nombre, String tipoAlbum) {
		if (obtenerParticipanteConDni(dni) != null)
			throw new RuntimeException("Ya hay un participante registrado con este DNI");
		
		Participante participante = new Participante(dni, nombre, tipoAlbum);
		
		participantes.add(participante);
		
		return participante.obtenerCodigoDeAlbum();
	}

	@Override
	public void comprarFiguritas(int dni) {
		this.verificarParticipanteRegistrado(dni);
		
		Participante participante = this.obtenerParticipanteConDni(dni);
		
		List<Figurita> figuritasNuevas = Figurita.generarFiguritas(4, TipoDeFigurita.Tradicional);
		
		participante.recibirFiguritas(figuritasNuevas);
	}

	@Override
	public void comprarFiguritasTop10(int dni) {
		this.verificarParticipanteRegistrado(dni);
		
		Participante participante = this.obtenerParticipanteConDni(dni);
		
		if (participante.obtenerTipoDeAlbumComprado() != "Extendido")
			throw new RuntimeException("Debes poseer un album extendido para adquirir figuritas Top10");
		
		List<Figurita> figuritasNuevas = Figurita.generarFiguritas(4, TipoDeFigurita.Top10);
		
		participante.recibirFiguritas(figuritasNuevas);
		
	}

	@Override
	public void comprarFiguritasConCodigoPromocional(int dni) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> pegarFiguritas(int dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean llenoAlbum(int dni) throws Exception {
		this.verificarParticipanteRegistrado(dni);
		
		Participante participante = this.obtenerParticipanteConDni(dni);
		
		return participante.completoAlbum();
	}

	@Override
	public String aplicarSorteoInstantaneo(int dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int buscarFiguritaRepetida(int dni) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean intercambiar(int dni, int codFigurita) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intercambiarUnaFiguritaRepetida(int dni) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String darNombre(int dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String darPremio(int dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listadoDeGanadores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> participantesQueCompletaronElPais(String nombrePais) {
		// TODO Auto-generated method stub
		return null;
	}
}	
