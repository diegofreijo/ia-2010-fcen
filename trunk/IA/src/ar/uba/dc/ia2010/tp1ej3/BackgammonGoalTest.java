package tp1ej3;

import aima.core.search.framework.GoalTest;

public class BackgammonGoalTest implements GoalTest
{
	BackgammonBoard goal = new BackgammonBoard(
			new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
			//new int[] {13, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0}
	);
	
	public boolean isGoalState(Object state)
	{
		BackgammonBoard tablero = (BackgammonBoard) state;
		return tablero.equals(goal);
	}	
}
