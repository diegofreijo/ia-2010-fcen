package tp1ej3.heuristicas;

import tp1ej3.BackgammonBoard;
import aima.core.search.framework.HeuristicFunction;

public class AEstrella2 implements HeuristicFunction
{
	/**
	 * Asumo que me va a salir siempre 6 y que puedo sacar una ficha en cualquier momento.
	 * Considero cuantos dados (con 6) tengo q sacar segun la columna donde esta la ficha.
	 */
	public double h(Object state)
	{
		BackgammonBoard tablero = (BackgammonBoard)state;
		double ret = 0;
		for(int col = 0; col < tablero.Longitud(); ++col)
		{
			if(tablero.FichasEnColumna(col) > 0)
			{
				double costoPorFicha = Math.ceil((tablero.Longitud() - col) / 6.0);
				ret += costoPorFicha * tablero.FichasEnColumna(col);
			}
		}
		
		return ret;
	}
}
