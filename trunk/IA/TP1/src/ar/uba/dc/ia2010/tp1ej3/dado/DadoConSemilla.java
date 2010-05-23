package tp1ej3.dado;

import java.util.Random;

public class DadoConSemilla extends Dado
{
	private Random r = null;
	
	public DadoConSemilla(long semilla)
	{
		r = new Random(semilla);
	}
	
	@Override
	public int Siguiente(int numeroDeJugada)
	{
		return r.nextInt(5) + 1;
	}
	
}
