package ar.uba.dc.ia2010.tp1ej2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;


public class bloquesOrdenados2dir implements ActionsFunction {

	@Override
	public Set<Action> actions(Object state)
	{
		final ArrayList<Integer> elementos = ((Tp1ej2State)state).elementos;
		final HashSet<Action> result = new HashSet<Action>();
		
		ArrayList<Bloque> bloques = Bloque.dividirEnBloquesOrdenados2Dirs(elementos);
		if( bloques.size() == 1 )
		{
			result.add( new Tp1ej2Action( new Tp1ej2State(
						bloques.get(0).elementos, bloques),
					bloques.get(0).elementos.size(),
					"bloque unico - " ) );
			return result;
		}
		
		// esto elige 2 bloques b1 y b2, los intercala, y pone el resultado en donde estaba b1
		
		for( int b1ind = 0; b1ind < bloques.size() - 1; b1ind++ )
		{
			for( int b2ind = b1ind + 1; b2ind < bloques.size(); b2ind++ )
			{
				ArrayList<Integer> a = new ArrayList<Integer>();
			
				// agrego todos los anteriores
				for( int i = 0; i < b1ind; i++ )
				{
					a.addAll( bloques.get(i).elementos );
				}
				// agrego el resultado de intercalar
				Bloque b1 = bloques.get(b1ind);
				Bloque b2 = bloques.get(b2ind);
				ArrayList<Integer> elementosIntercalados = Bloque.intercalar( b1, b2 );
				a.addAll( elementosIntercalados );
				// agrego lo que habia entre b1 y b2
				for( int i = b1ind + 1; i < b2ind; i++ )
				{
					a.addAll( bloques.get(i).elementos );
				}
				// agrego lo que resta desde b2 hasta el final
				for( int i = b2ind + 1; i < bloques.size(); i++ )
				{
					a.addAll( bloques.get(i).elementos );
				}
				result.add( new Tp1ej2Action(
						new Tp1ej2State(a, Bloque.dividirEnBloquesOrdenados2Dirs(a)),
						elementosIntercalados.size(),
						b1.elementos + " I " + b2.elementos + " = ") );
			}
		}

		return result;
	} // end of actions()
}
