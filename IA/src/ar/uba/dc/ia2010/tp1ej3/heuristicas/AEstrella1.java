package tp1ej3.heuristicas;

import tp1ej3.BackgammonBoard;
import aima.core.search.framework.HeuristicFunction;

public class AEstrella1 implements HeuristicFunction
{
	/**
	 * Cuento la cantidad de fichas que quedan en juego. 
	 */
	public double h(Object state)
	{
		BackgammonBoard tablero = (BackgammonBoard)state;
		double ret = 0;
		for(int col = 0; col < tablero.Longitud(); ++col)
		{
			ret += tablero.FichasEnColumna(col);
		}
		
		return ret;
	}
}
