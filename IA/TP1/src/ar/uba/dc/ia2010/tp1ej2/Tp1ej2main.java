package ar.uba.dc.ia2010.tp1ej2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.informed.AStarSearch;
import aima.core.search.informed.GreedyBestFirstSearch;


public class Tp1ej2main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(11);
		input.add(12);
		input.add(13);
		input.add(14);
		input.add(6);
		input.add(5);
		input.add(16);
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		input.add(1);
		input.add(2);
		input.add(1);
		input.add(2);
		input.add(1);
		input.add(2);
		input.add(1);
		input.add(2);
		input.add(1);
		input.add(2);
		input.add(1);
		input.add(2);

		Tp1ej2State initialState = new Tp1ej2State( input );
		
		Problem problemElementosContiguos = new Problem(
				initialState,
				new elementosContiguos(),
				new Tp1ej2ResultF(),
				new Tp1ej2GoalTest(),
				new Tp1ej2StepCostFuncion() );
		Problem problemElementosContiguosOrdenados = new Problem(
				initialState,
				new elementosContiguosOrdenados(),
				new Tp1ej2ResultF(),
				new Tp1ej2GoalTest(),
				new Tp1ej2StepCostFuncion() );
		
		Problem problemBloquesContiguosOrdenados = new Problem(
				initialState,
				new bloquesContiguosOrdenados(),
				new Tp1ej2ResultF(),
				new Tp1ej2GoalTest(),
				new Tp1ej2StepCostFuncion() );
		Problem problemBloquesOrdenados = new Problem(
				initialState,
				new bloquesOrdenados(),
				new Tp1ej2ResultF(),
				new Tp1ej2GoalTest(),
				new Tp1ej2StepCostFuncion() );
		Problem problemBloquesOrdenados2dir = new Problem(
				initialState,
				new bloquesOrdenados2dir(),
				new Tp1ej2ResultF(),
				new Tp1ej2GoalTest(),
				new Tp1ej2StepCostFuncion() );
		
		Search myBestFirstHeurTrivial = new GreedyBestFirstSearch( new GraphSearch(),
				new HeurTrivial() );
		Search myAStarHeurTrivial = new AStarSearch(new GraphSearch(),
				new HeurTrivial());

		Search myBestFirstHeurElementos1 = new GreedyBestFirstSearch( new GraphSearch(),
				new HeurElementos1() );
		Search myAStarHeurElementos1= new AStarSearch(new GraphSearch(),
				new HeurElementos1());

		Search myBestFirstHeurElementos2 = new GreedyBestFirstSearch( new GraphSearch(),
				new HeurElementos2() );
		Search myAStarHeurElementos2= new AStarSearch(new GraphSearch(),
				new HeurElementos2());

		Search myBestFirstHeurBloque1 = new GreedyBestFirstSearch( new GraphSearch(),
				new HeurBloque1() );
		Search myAStarHeurBloque1= new AStarSearch(new GraphSearch(),
				new HeurBloque1());

		Search myBestFirstHeurBloque2 = new GreedyBestFirstSearch( new GraphSearch(),
				new HeurBloque2() );
		Search myAStarHeurBloque2= new AStarSearch(new GraphSearch(),
				new HeurBloque2());
		try {
			SearchAgent agent = new SearchAgent(
					problemBloquesOrdenados, myAStarHeurBloque2 );

			System.out.println("El camino tiene " + agent.getActions().size() + " acciones");
			System.out.println("Estado incial: " + initialState.elementos.toString());
			printActions( agent.getActions() );
			printInstrumentation( agent.getInstrumentation() );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printInstrumentation(Properties properties) {
		Iterator<Object> keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}
	}

	private static void printActions(List<Action> actions) {
		for (int i = 0; i < actions.size(); i++) {
			String action = actions.get(i).toString();
			System.out.println(action);
		}
	}
}