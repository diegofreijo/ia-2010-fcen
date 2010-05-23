package ar.uba.dc.ia2010.tp1ej2;

import aima.core.agent.Action;
import aima.core.search.framework.StepCostFunction;

public class Tp1ej2StepCostFuncion implements StepCostFunction {

	@Override
	public double c(Object s, Action a, Object sPrime) {
		// TODO Auto-generated method stub
		return ((Tp1ej2Action)a).getCost();
	}
}
