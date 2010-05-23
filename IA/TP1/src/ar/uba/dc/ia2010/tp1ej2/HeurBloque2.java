package ar.uba.dc.ia2010.tp1ej2;

import java.util.ArrayList;

import aima.core.search.framework.HeuristicFunction;

public class HeurBloque2 implements HeuristicFunction {

	@Override
	public double h(Object state) {
		// castear state y calcular h(state)
		ArrayList<Integer> elementos = ((Tp1ej2State)state).elementos;
		ArrayList<Bloque> bloques = ((Tp1ej2State)state).bloques;
		
		int min = bloques.get(0).elementos.size();
		int max = min;
		for( int i = 1; i < bloques.size(); i++ )
		{
			int tamDeEste = bloques.get(i).elementos.size();
			if( min > tamDeEste )
				min = tamDeEste;
			if( max < tamDeEste )
				max = tamDeEste;
		}
		int result = ( bloques.size() - 1 ) * min * 2 - min + max;
		if( elementos.size() > result )
			result = bloques.size();
		return result;
	}
}
