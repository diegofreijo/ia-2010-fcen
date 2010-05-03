package ar.uba.dc.ia2010.tp1ej2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import ar.uba.dc.ia2010.tp1ej2.Bloque.dirBloque;


public class bloquesContiguosOrdenados implements ActionsFunction {

	@Override
	public Set<Action> actions(Object state)
	{
		final ArrayList<Integer> elementos = ((Tp1ej2State)state).elementos;
		final HashSet<Action> result = new HashSet<Action>();
		
		ArrayList<Bloque> bloques = Bloque.dividirEnBloquesOrdenados(elementos);
		if( bloques.size() == 1 )
		{
			if( bloques.get(0).dir == dirBloque.DECRECIENTE )
			{
				// ver todo!	
			}
			result.add( new Tp1ej2Action( new Tp1ej2State(bloques.get(0).elementos ),
					bloques.get(0).elementos.size() ) );
			return result;
		}
		
		for( int i = 0; i < bloques.size() - 1; i++ )
		{
			ArrayList<Integer> a = new ArrayList<Integer>();
			
			// agrego todos los anteriores
			for( int j = 0; j < i; j++ )
			{
				a.addAll( bloques.get(j).elementos );
			}
			// agrego el resultado de intercalar
			Bloque b1 = bloques.get(i);
			Bloque b2 = bloques.get(i+1);
			ArrayList<Integer> elementosIntercalados= Bloque.intercalar( b1, b2 );
			a.addAll( elementosIntercalados );
			// agrego lo que sigue
			for( int j = i + 2; j < bloques.size(); j++ )
			{
				a.addAll( bloques.get(j).elementos );
			}
			result.add( new Tp1ej2Action( new Tp1ej2State(a,Bloque.dividirEnBloquesOrdenados(a)),
					elementosIntercalados.size() ) );
		}

		return result;
	} // end of actions()
}
