package ar.uba.dc.ia2010.tp1ej2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;

public class elementosContiguos implements ActionsFunction {

	@Override
	public Set<Action> actions(Object state)
	{
		final ArrayList<Integer> elementos = ((Tp1ej2State)state).elementos;
		final HashSet<Action> result = new HashSet<Action>();
		
		for( int i = 0; i < elementos.size() - 1; i++ )
		{
			int j = i + 1;
			final ArrayList<Integer> a = new ArrayList<Integer>(elementos);
			Integer swapAux = a.get(i);
			a.set( i, a.get(j) );
			a.set( j, swapAux );
			result.add( new Tp1ej2Action( new Tp1ej2State(a) ) );
		}

		return result;
	} // end of actions()
}
