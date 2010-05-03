package ar.uba.dc.ia2010.tp1ej2;

import aima.core.search.framework.HeuristicFunction;

public class HeurTrivial implements HeuristicFunction {

	@Override
	public double h(Object state) {
		// castear state y calcular h(state)
		Tp1ej2State myState = (Tp1ej2State) state;

		//		return myState.elementos.size();
		//return 0;
		
		return myState.isGoal()? 0:2;
	}
}
