package ar.uba.dc.ia2010.ej1;

import aima.core.search.framework.HeuristicFunction;

public class CasillasFueraDeLugarHeuristica implements HeuristicFunction {

	private int[] array = { 1, 2, 3, 8, 0, 4, 7, 6, 5 };
	@Override
	public double h(Object state) {

		State s = (State)state;
		int cant = 0;
		for (int i = 0; i < array.length; i++)
			if (array[i] != s.getArray()[i])
				cant++;
		return cant;

	}

}
