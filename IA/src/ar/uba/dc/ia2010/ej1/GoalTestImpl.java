package ar.uba.dc.ia2010.ej1;

import aima.core.search.framework.GoalTest;

public class GoalTestImpl implements GoalTest {

	@Override
	public boolean isGoalState(Object state) {
		try  {
			int[] array = {1,2,3,8,0,4,7,6,5};
			State finalState = new State(array);
			State s =(State)state;

			return s.equals(finalState);

		} catch (Exception e) {
			return false;
		}
	}

}
