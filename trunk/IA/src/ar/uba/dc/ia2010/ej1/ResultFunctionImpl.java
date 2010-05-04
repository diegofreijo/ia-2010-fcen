package ar.uba.dc.ia2010.ej1;

import aima.core.agent.Action;
import aima.core.search.framework.ResultFunction;

public class ResultFunctionImpl implements ResultFunction {

	@Override
	public Object result(Object s, Action a) {

		State state = (State)s;
		int[] newState = new int[state.getArray().length];
		for (int i = 0; i < newState.length; i++) {
			newState[i] = state.getArray()[i];
		}
		MoverADireccionAction accion = (MoverADireccionAction)a;
		int zeroPos = Utils.zeroPosition(state.getArray());
		int aMover;
		switch (accion.getDireccion()) {
			case Norte:
				aMover = newState[zeroPos-3];
				newState[zeroPos-3] = 0;
				newState[zeroPos] = aMover;
				break;
			case Sur:
				aMover = newState[zeroPos+3];
				newState[zeroPos+3] = 0;
				newState[zeroPos] = aMover;
				break;
			case Este:
				aMover = newState[zeroPos+1];
				newState[zeroPos+1] = 0;
				newState[zeroPos] = aMover;
				break;
			case Oeste:
				aMover = newState[zeroPos-1];
				newState[zeroPos-1] = 0;
				newState[zeroPos] = aMover;
				break;
		}

		return new State(newState);
	}

}
