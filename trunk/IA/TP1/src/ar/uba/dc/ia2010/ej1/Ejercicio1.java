package ar.uba.dc.ia2010.ej1;

import java.util.List;

import aima.core.agent.Action;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.eightpuzzle.EightPuzzleFunctionFactory;
import aima.core.environment.eightpuzzle.EightPuzzleGoalTest;
import aima.core.environment.eightpuzzle.ManhattanHeuristicFunction;
import aima.core.environment.eightpuzzle.MisplacedTilleHeuristicFunction;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.HeuristicFunction;
import aima.core.search.framework.Metrics;
import aima.core.search.framework.Problem;
import aima.core.search.informed.AStarSearch;
import aima.core.search.informed.GreedyBestFirstSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;
import aima.core.search.uninformed.IterativeDeepeningSearch;

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


//		Problem p = new Problem(istate, new ActionsFunctionImpl(), new ResultFunctionImpl(), new GoalTestImpl());

		EightPuzzleGoalTest goal = new EightPuzzleGoalTest() {
			public boolean isGoalState(Object state) {
				int[] finals = {1,2,3,8,0,4,7,6,5};
				EightPuzzleBoard board = (EightPuzzleBoard) state;
				return board.equals(new EightPuzzleBoard(finals));
			}
		};

		Problem p = new Problem(
				new EightPuzzleBoard(initialState),
				EightPuzzleFunctionFactory.getActionsFunction(),
				EightPuzzleFunctionFactory.getResultFunction(),
				goal);

		BreadthFirstSearch bfs = new BreadthFirstSearch();
		List<Action> list = bfs.search(p);

		System.out.println("BreadthFirstSearch");

		Metrics metricas = bfs.getMetrics();
		System.out.print("[ ");
		for (Action action : list) {
			System.out.print(action + " ");
		}
		System.out.println("]");
		System.out.println("nodesExpanded: " + metricas.get("nodesExpanded"));

		DepthFirstSearch dfs = new DepthFirstSearch(new GraphSearch());

		list = dfs.search(p);
		metricas = dfs.getMetrics();

		System.out.println("DepthFirstSearch");
		System.out.println("solutionLenght: " + list.size());
		System.out.println("nodesExpanded: " + metricas.get("nodesExpanded"));

		DepthLimitedSearch dls = new DepthLimitedSearch(20);

		list = dls.search(p);
		metricas = dls.getMetrics();

		System.out.println("DepthLimitedSearch");
		System.out.print("[ ");
		for (Action action : list) {
			System.out.print(action + " ");
		}
		System.out.println("]");
		System.out.println("nodesExpanded: " + metricas.get("nodesExpanded"));

		IterativeDeepeningSearch ids = new IterativeDeepeningSearch();

		list = ids.search(p);
		metricas = ids.getMetrics();

		System.out.println("IterativeDeepeningSearch");
		System.out.print("[ ");
		for (Action action : list) {
			System.out.print(action + " ");
		}
		System.out.println("]");
		System.out.println("nodesExpanded: " + metricas.get("nodesExpanded"));

		GreedyBestFirstSearch greedy = new GreedyBestFirstSearch(
				new GraphSearch(),
				new HeuristicFunction() {

					@Override
					public double h(Object state) {
						return 0;
					}

				}
		);

		list = greedy.search(p);
		metricas = greedy.getMetrics();
		System.out.println("GreedyBestFirstSearch - H1");
		System.out.println("solutionLenght: " + list.size());
		System.out.println("nodesExpanded: " + metricas.get("nodesExpanded"));

		GreedyBestFirstSearch greedy1 = new GreedyBestFirstSearch(
				new GraphSearch(),
				new MisplacedTilleHeuristicFunction()
		);

		list = greedy1.search(p);
		metricas = greedy1.getMetrics();
		System.out.println("GreedyBestFirstSearch - H2");
		System.out.println("solutionLenght: " + list.size());
		System.out.println("nodesExpanded: " + metricas.get("nodesExpanded"));

		GreedyBestFirstSearch greedy2 = new GreedyBestFirstSearch(
				new GraphSearch(),
				new ManhattanHeuristicFunction()
		);

		list = greedy2.search(p);
		metricas = greedy2.getMetrics();
		System.out.println("GreedyBestFirstSearch - H3");
		System.out.println("solutionLenght: " + list.size());
		for (Action action : list) {
			System.out.print(action + " ");
		}
		System.out.println("]");
		System.out.println("nodesExpanded: " + metricas.get("nodesExpanded"));

		GreedyBestFirstSearch greedy3 = new GreedyBestFirstSearch(
				new GraphSearch(),
				new ManhattanHeuristicFunction()
		);

		list = greedy3.search(p);
		metricas = greedy3.getMetrics();
		System.out.println("GreedyBestFirstSearch - H4");
		System.out.println("solutionLenght: " + list.size());
		System.out.println("nodesExpanded: " + metricas.get("nodesExpanded"));

		AStarSearch ass = new AStarSearch(
				new GraphSearch(),
				new HeuristicFunction() {

					@Override
					public double h(Object state) {
						return 0;
					}

				}
				);

		list = ass.search(p);

		metricas = ass.getMetrics();
		System.out.println("AStarSearch - H1");
		System.out.print("[ ");
		for (Action action : list) {
			System.out.print(action + " ");
		}
		System.out.println("]");
		System.out.println("nodesExpanded: " + metricas.get("nodesExpanded"));

		AStarSearch ass1 = new AStarSearch(
				new GraphSearch(),
				new MisplacedTilleHeuristicFunction()
				);

		list = ass1.search(p);

		metricas = ass1.getMetrics();
		System.out.println("AStarSearch - H2");
		System.out.print("[ ");
		for (Action action : list) {
			System.out.print(action + " ");
		}
		System.out.println("]");
		System.out.println("nodesExpanded: " + metricas.get("nodesExpanded"));

		AStarSearch ass2 = new AStarSearch(
				new GraphSearch(),
				new ManhattanHeuristicFunction()
				);

		list = ass2.search(p);

		metricas = ass2.getMetrics();
		System.out.println("AStarSearch - H3");
		System.out.print("[ ");
		for (Action action : list) {
			System.out.print(action + " ");
		}
		System.out.println("]");
		System.out.println("nodesExpanded: " + metricas.get("nodesExpanded"));

		AStarSearch ass3 = new AStarSearch(
				new GraphSearch(),
				new ManhattanHeuristicFunction()
				);

		list = ass3.search(p);

		metricas = ass3.getMetrics();
		System.out.println("AStarSearch - H4");
		System.out.print("[ ");
		for (Action action : list) {
			System.out.print(action + " ");
		}
		System.out.println("]");
		System.out.println("nodesExpanded: " + metricas.get("nodesExpanded"));
	}

}
