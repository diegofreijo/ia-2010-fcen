package tp1ej3.dado;

import java.util.Random;

public class DadoAzaroso extends Dado
{
	private Random r = new Random();
	
	@Override
	public int Siguiente(int numeroDeJugada)
	{
		return r.nextInt(6) + 1;
	}
	
}
