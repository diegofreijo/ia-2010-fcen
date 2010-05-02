package ar.uba.dc.ia2010.ej1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.GoalTest;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.QueueSearch;
import aima.core.search.framework.TreeSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;

public class Ejercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("hola mundo");

		int[] initialState = {2,8,1,4,6,3,0,7,5};
		int[] finals = {1,2,3,8,0,4,7,6,5};

//		ActionsFunction af = new ActionsFunctionImpl();
//
//		GoalTest goal = new GoalTestImpl();
//
//		Set<Action> set = af.actions(initialState);
//
//		for (Action action : set) {
//			System.out.println(action);
//		}
//
//		System.out.println(goal.isGoalState(initialState));
//		System.out.println(goal.isGoalState(finals));
//
//

		Problem p = new Problem(initialState, new ActionsFunctionImpl(), new ResultFunctionImpl(), new GoalTestImpl());

		BreadthFirstSearch bfs = new BreadthFirstSearch();
		List<Action> list = bfs.search(p);

		QueueSearch qs = new TreeSearch();
		DepthFirstSearch dfs = new DepthFirstSearch(qs);

		for (Action action : list) {
			System.out.println(action);
		}

		list = dfs.search(p);

		for (Action action : list) {
			System.out.println(action);
		}
	}

}
