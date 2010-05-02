package ar.uba.dc.ia2010.ej1;

import aima.core.search.framework.GoalTest;

public class GoalTestImpl implements GoalTest {

	@Override
	public boolean isGoalState(Object state) {
		try  {
			int[] finalState = {1,2,3,8,0,4,7,6,5}; 
			int[] s =(int[])state;
			
			if (s.length != finalState.length)
				return false;
			
			for (int i = 0; i < finalState.length; i++) 
				if (finalState[i]!=s[i])
					return false;	
							
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

}
