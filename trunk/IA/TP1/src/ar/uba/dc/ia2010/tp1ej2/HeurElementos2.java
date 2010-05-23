package ar.uba.dc.ia2010.tp1ej2;

import java.util.ArrayList;

import aima.core.search.framework.HeuristicFunction;

public class HeurElementos2 implements HeuristicFunction {

	@Override
	public double h(Object state) {
		// castear state y calcular h(state)

		final ArrayList<Integer> elementos = ((Tp1ej2State)state).elementos;
		int result = 0;
		for( int i = 0; i < elementos.size() - 1; i++ )
		{
			if( elementos.get(i) > elementos.get(i+1) )
			{
				result += 2;
				if( i > 0 && elementos.get(i-1) > elementos.get(i+1) )
				{
					result += 2;
				}
			}
		}

		return result;
	}
}
