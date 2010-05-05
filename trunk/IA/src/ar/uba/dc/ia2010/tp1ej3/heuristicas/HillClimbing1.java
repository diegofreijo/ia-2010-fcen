package tp1ej3.heuristicas;

import tp1ej3.BackgammonBoard;
import aima.core.search.framework.HeuristicFunction;

public class HillClimbing1 implements HeuristicFunction
{
	/**
	 * Cuento las columas que le quedan a cada ficha, dandole mas costo a las que estan en
	 * el primer cuadrante.
	 */
	public double h(Object state)
	{
		BackgammonBoard tablero = (BackgammonBoard)state;
		double ret = 0;
		for(int col = 0; col < tablero.Longitud() / 2; ++col)
		{
			double costoPorFicha = (tablero.Longitud() - col) * 2;
			ret += tablero.FichasEnColumna(col) * costoPorFicha;
		}
		for(int col = tablero.Longitud() / 2; col < tablero.Longitud(); ++col)
		{
			double costoPorFicha = (tablero.Longitud() - col);
			ret += tablero.FichasEnColumna(col) * costoPorFicha;
		}
		
		return ret;
	}
}
