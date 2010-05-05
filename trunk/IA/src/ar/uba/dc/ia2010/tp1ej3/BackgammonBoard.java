package tp1ej3;


public class BackgammonBoard
{	
	private int[] tablero = null;
	private int numeroDeJugada = 0;
	public int NumeroDeJugada() { return numeroDeJugada; }
	
	public BackgammonBoard()
	{
		tablero = new int[] { 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		numeroDeJugada = 0;
	}
	
	public BackgammonBoard(int[] tablero)
	{
		this.tablero = new int[tablero.length];
		System.arraycopy(tablero, 0, this.tablero, 0, tablero.length);
		this.numeroDeJugada = 0;
	}
	
	public BackgammonBoard(BackgammonBoard otro)
	{
		this.tablero = new int[otro.tablero.length];
		System.arraycopy(otro.tablero, 0, this.tablero, 0, otro.tablero.length);
		this.numeroDeJugada = otro.numeroDeJugada;
	}

	public boolean PuedoMoverFicha(int desde, int hasta)
	{
		//double a = 1/0;
		return 
			// Bordes
			desde >= 0 &&
			// Coherencia entre origen y destino
			desde < hasta &&
			// Exista ficha que mover
			FichasEnColumna(desde) > 0 &&
			// No puedo sacar fichas mientras no este en la segunda etapa
			(SegundaEtapa() || hasta < tablero.length) &&
			// Si estoy en la segunda etapa, puedo mover desde la primer hasta la ultima barra
			(!SegundaEtapa() || !HayFichasAntesDe(desde));
	}

	
	private boolean HayFichasAntesDe(int desde)
	{
		for(int i = 0; i < desde; ++i)
		{
			if(FichasEnColumna(i) > 0)
				return true;
		}
		return false;
	}

	public void MoverFicha(int desde, int hasta)
	{
		tablero[desde]--;
		
		// Puedo sacar la ficha del tablero si no quedo ninguna en el 1er cuadrante
		if(hasta < tablero.length)
		{
			tablero[hasta]++;
		}
		else if(PrimerCuadranteTieneFichas())
		{
			tablero[tablero.length-1]++;
		}
		numeroDeJugada++;
	}
	
	private boolean PrimerCuadranteTieneFichas()
	{
		for(int i = 0; i < tablero.length / 2; ++i)
		{
			if(FichasEnColumna(i) > 0)
				return true;
		}
		return false;
	}
	
	/**
	 * Dice si el juego ya esta en la segunda etapa: cuando todas las fichas estan en el segundo cuadrante
	 * @return
	 */
	private boolean SegundaEtapa()
	{
		return !PrimerCuadranteTieneFichas();
	}

	public int FichasEnColumna(int columna)
	{
		return tablero[columna];
	}
	
	public int Longitud()
	{
		return tablero.length;
	}	
	
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass()))
		{
			return false;
		}
		BackgammonBoard otro = (BackgammonBoard) o;
		
		for (int i = 0; i < tablero.length; i++)
		{
			if (FichasEnColumna(i) != otro.FichasEnColumna(i))
			{
				return false;
			}
		}
		return true;
	}

	public String toString()
	{
		String ret = "{ ";
		
		for(int i = 0; i < tablero.length; ++i)
		{
			ret += FichasEnColumna(i) + ", ";
		}
		
		ret += "}";
		
		return ret;
	}
}
