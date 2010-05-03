package ar.uba.dc.ia2010.tp1ej2;

import java.util.ArrayList;

import aima.core.search.framework.HeuristicFunction;

public class HeurBloque1 implements HeuristicFunction {

	@Override
	public double h(Object state) {
		// castear state y calcular h(state)
		ArrayList<Bloque> bloques = ((Tp1ej2State)state).bloques;
		
		int min = bloques.get(0).elementos.size();
		for( int i = 1; i < bloques.size(); i++ )
		{
			int tamDeEste = bloques.get(i).elementos.size();
			if( min > tamDeEste )
				min = tamDeEste;
		}
		return ( bloques.size() - 1 ) * min * 2;
	}
}
