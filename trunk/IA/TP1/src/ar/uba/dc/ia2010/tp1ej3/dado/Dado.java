package tp1ej3.dado;

public abstract class Dado
{
	public abstract int Siguiente(int numeroDeJugada);
	
	private static Dado dado = null;
	
	public static Dado Instancia()
	{
		return dado;
	}
	
	public static void EstablecerInstancia(Dado dado)
	{
		Dado.dado = dado;
	}
}
