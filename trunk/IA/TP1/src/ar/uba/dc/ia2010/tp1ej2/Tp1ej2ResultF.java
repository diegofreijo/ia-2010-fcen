package ar.uba.dc.ia2010.tp1ej2;

import aima.core.agent.Action;
import aima.core.search.framework.ResultFunction;

public class Tp1ej2ResultF implements ResultFunction {

	@Override
	public Object result(Object currentState, Action action) {
		if( action.isNoOp() )
		{
			return currentState;
		}
		return ((Tp1ej2Action)action).newState;
	}
}
