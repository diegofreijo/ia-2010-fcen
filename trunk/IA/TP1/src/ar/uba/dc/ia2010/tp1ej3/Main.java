package tp1ej3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import tp1ej3.dado.Dado;
import tp1ej3.dado.DadoConSemilla;
import tp1ej3.dado.DadoPredefinido;
import tp1ej3.heuristicas.AEstrella1;
import tp1ej3.heuristicas.AEstrella2;
import tp1ej3.heuristicas.HillClimbing1;
import aima.core.agent.Action;
import aima.core.search.framework.GraphSearch;
import aima.core.search.framework.HeuristicFunction;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.TreeSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.local.HillClimbingSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;

public class Main
{
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
//			ResolverHillClimbing(new HillClimbing1());
//			ResolverAEstrella(new AEstrella1());			
			ResolverAEstrella(new AEstrella2());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void ResolverDFS() throws Exception
	{
		Dado.EstablecerInstancia(new DadoPredefinido());
		
		Search busqueda = new DepthFirstSearch(new TreeSearch());
		Resolver(busqueda);
	}
	private static void ResolverAEstrella(HeuristicFunction h) throws Exception
	{
		Dado.EstablecerInstancia(new DadoPredefinido());
		
		Search busqueda = new AStarSearch(new GraphSearch(), h);
		Resolver(busqueda);
	}
	private static void ResolverHillClimbing(HeuristicFunction h) throws Exception
	{
		Search busqueda = new HillClimbingSearch(h);
		List<Properties> resultados = new LinkedList<Properties>();
		for(int i = 0; i < 1000; ++i)
		{
			Dado.EstablecerInstancia(new DadoConSemilla(i));
			resultados.add(ResolverHillClimbing(busqueda));
		}
		
		System.out.println(resultados.toString());
		LinkedList<Integer> costos = new LinkedList<Integer>();
		List<Integer> nodosExpandidos = new LinkedList<Integer>();
		for(Properties p : resultados)
		{
			costos.add(Integer.valueOf(p.getProperty("costo")));
			nodosExpandidos.add(Integer.valueOf(p.getProperty("nodesExpanded")));
		}
		
		System.out.println("Costos");
		System.out.println("Maximo: " + Max(costos));
		System.out.println("Minimo: " + Min(costos));
		System.out.println("Promedio: " + Promedio(costos));
		
		System.out.println("Nodos expandidos");
		System.out.println("Maximo: " + Max(nodosExpandidos));
		System.out.println("Minimo: " + Min(nodosExpandidos));
		System.out.println("Promedio: " + Promedio(nodosExpandidos));
	}
	
	
	private static Properties ResolverHillClimbing(Search busqueda) throws Exception
	{
		// Defino el problema y dejo q la libreria lo resuelva
		Problem problema = new Problem
		(
			new BackgammonBoard(),
			BackgammonFunctionFactory.getActionsFunction(),
			BackgammonFunctionFactory.getResultFunction(),
			new BackgammonGoalTest()
		);
		SearchAgent agente = new SearchAgent(problema, busqueda);
		
		
		// Devuelvo resultados
		Properties ret = agente.getInstrumentation();
		ret.setProperty("costo", String.valueOf(agente.getActions().size()));
		return ret;
	}
	
	private static void Resolver(Search busqueda) throws Exception
	{
		System.out.println("Jugando... ");
		long startTime = Calendar.getInstance().getTimeInMillis();
		
		// Defino el problema y dejo q la libreria lo resuelva
		Problem problema = new Problem
		(
			new BackgammonBoard(),
			BackgammonFunctionFactory.getActionsFunction(),
			BackgammonFunctionFactory.getResultFunction(),
			new BackgammonGoalTest()
		);
		SearchAgent agente = new SearchAgent(problema, busqueda);
		
		// Imprimo el tiempo tardado
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
		Calendar cal = Calendar.getInstance();
		long elapsed = cal.getTimeInMillis() - startTime;
		cal.setTimeInMillis(elapsed);
		System.out.println("Listo! Tarde " + dateFormat.format(cal.getTime()));
		
		// Imprimo resultados
		printActions(agente.getActions());
		printInstrumentation(agente.getInstrumentation());
	}
	
	
	private static void printActions(List<Action> actions)
	{
		for (Action action : actions)
		{
			System.out.println(action.toString());
		}
	}
	
	private static void printInstrumentation(Properties properties)
	{
		System.out.println(properties.toString());
	}
	
	private static Integer Max(List<Integer> lista)
	{
		Integer ret = lista.get(0);
		for(Integer i : lista)
		{
			if(i > ret)
				ret = i;
		}
		return ret;
	}
	private static Integer Min(List<Integer> lista)
	{
		Integer ret = lista.get(0);
		for(Integer i : lista)
		{
			if(i < ret)
				ret = i;
		}
		return ret;
	}
	private static double Promedio(List<Integer> lista)
	{
		Integer ret = 0;
		for(Integer i : lista)
		{
			ret += i;
		}
		return ret / (double)lista.size();
	}
}
