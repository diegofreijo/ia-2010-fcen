package ar.uba.dc.ia2010.tp1ej2;

import aima.core.search.framework.GoalTest;

public class Tp1ej2GoalTest implements GoalTest {

	@Override
	public boolean isGoalState(Object arg0) {
		return ((Tp1ej2State) arg0).isGoal();
	}

}
