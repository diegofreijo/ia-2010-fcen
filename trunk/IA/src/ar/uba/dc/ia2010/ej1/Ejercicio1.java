package ar.uba.dc.ia2010.ej1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.eightpuzzle.EightPuzzleFunctionFactory;
import aima.core.environment.eightpuzzle.EightPuzzleGoalTest;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.EvaluationFunction;
import aima.core.search.framework.GoalTest;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.HeuristicFunction;
import aima.core.search.framework.Metrics;
import aima.core.search.framework.Node;
import aima.core.search.framework.Problem;
import aima.core.search.framework.QueueSearch;
import aima.core.search.framework.TreeSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.informed.BestFirstSearch;
import aima.core.search.informed.GreedyBestFirstEvaluationFunction;
import aima.core.search.informed.GreedyBestFirstSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;

public class Ejercicio1 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//System.out.println("hola mundo");

		int[] initialState = {2,8,1,4,6,3,0,7,5};
		int[] finals = {1,2,3,8,0,4,7,6,5};
		State istate = new State(initialState);
		State ostate = new State(initialState);
		State fstate = new State(finals);


//
//		System.out.println(istate.equals(fstate));
//		System.out.println(istate.equals(ostate));


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
		//EightPuzzleBoard board = new EightPuzzleBoard(initialState);


		Problem p = new Problem(istate, new ActionsFunctionImpl(), new ResultFunctionImpl(), new GoalTestImpl());
//		Problem p = new Problem(
//				new EightPuzzleBoard(initialState),
//				EightPuzzleFunctionFactory.getActionsFunction(),
//				EightPuzzleFunctionFactory.getResultFunction(),
//				new EightPuzzleGoalTest());

//		BreadthFirstSearch bfs = new BreadthFirstSearch();
//		List<Action> list = bfs.search(p);
//
//		System.out.println("BreadthFirstSearch");
//
//		Metrics metricas = bfs.getMetrics();
//		System.out.print("[ ");
//		for (Action action : list) {
//			System.out.print(action + " ");
//		}
//		System.out.println("]");
//		System.out.println("maxQueueSize: " + metricas.get("maxQueueSize"));
//		System.out.println("queueSize: " + metricas.get("queueSize"));
//		System.out.println("nodesExpanded: " + metricas.get("nodesExpanded"));

		//QueueSearch qs = new GraphSearch();
		DepthLimitedSearch dfs = new DepthLimitedSearch(13);

		List<Action>  list = dfs.search(p);
		Metrics metricas = dfs.getMetrics();

		System.out.println("DepthFirstSearch");
		System.out.print("[ ");
		for (Action action : list) {
			System.out.print(action + " ");
		}
		System.out.println("]");
		System.out.println("maxQueueSize: " + metricas.get("maxQueueSize"));
		System.out.println("queueSize: " + metricas.get("queueSize"));
		System.out.println("nodesExpanded: " + metricas.get("nodesExpanded"));

//		GreedyBestFirstSearch bfs = new GreedyBestFirstSearch(new GraphSearch(), new HeuristicFunction(){
//
//			@Override
//			public double h(Object state) {
//				int[] array = {1,2,3,8,0,4,7,6,5};
//				State s =(State)state;
//				int cant=0;
//				for (int i = 0; i < array.length; i++)
//					if (array[i] == s.getArray()[i])
//						cant++;
//				return cant;
//		}});

//		AStarSearch bfs = new AStarSearch(new GraphSearch(), new HeuristicFunction(){
//
//			@Override
//			public double h(Object state) {
//				int[] array = {1,2,3,8,0,4,7,6,5};
//				State s =(State)state;
//				int cant=0;
//				for (int i = 0; i < array.length; i++)
//					if (array[i] == s.getArray()[i])
//						cant++;
//				return cant;
//		}});
//
//
//		try {
//			List<Action> list = null;
//			list = bfs.search(p);
//
//			Metrics metricas = bfs.getMetrics();
//			System.out.println("BestFirstSearch");
//			System.out.print("[ ");
//			for (Action action : list) {
//				System.out.print(action + " ");
//			}
//			System.out.println("]");
//			System.out.println("maxQueueSize: " + metricas.get("maxQueueSize"));
//			System.out.println("queueSize: " + metricas.get("queueSize"));
//			System.out.println("nodesExpanded: " + metricas.get("nodesExpanded"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
