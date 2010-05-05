package tp1ej3;

import java.util.LinkedHashSet;
import java.util.Set;

import tp1ej3.dado.Dado;
import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;

public class BackgammonFunctionFactory
{	
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;
	
	public static ActionsFunction getActionsFunction()
	{
		if (null == _actionsFunction)
		{
			_actionsFunction = new EPActionsFunction();
		}
		return _actionsFunction;
	}
	
	public static ResultFunction getResultFunction()
	{
		if (null == _resultFunction)
		{
			_resultFunction = new EPResultFunction();
		}
		return _resultFunction;
	}
	
	private static class EPActionsFunction implements ActionsFunction
	{
		private static int ultimoNivelRecorrido = 0;
		
		public Set<Action> actions(Object state)
		{
			BackgammonBoard board = (BackgammonBoard) state;
			Set<Action> actions = new LinkedHashSet<Action>();
			
			// Tiro el dado
			int dado = Dado.Instancia().Siguiente(board.NumeroDeJugada());
			
			// Junto las movidas validas
			for(int desde = 0; desde < board.Longitud(); ++desde)
			{
				int hasta = desde + dado;
				if(board.PuedoMoverFicha(desde, hasta))
				{
					actions.add(new AccionBackgammon(desde, hasta, dado));
				}
			}
			
//			if(board.NumeroDeJugada() != ultimoNivelRecorrido)
//			{
//				ultimoNivelRecorrido = board.NumeroDeJugada();
//				System.out.print(ultimoNivelRecorrido + " ");
//			}
//			System.out.println(
//					board.NumeroDeJugada() + ". " + actions.toString() + 
//					"		" + board.toString());

			return actions;
		}
	}
	
	private static class EPResultFunction implements ResultFunction
	{
		public Object result(Object s, Action a)
		{
			BackgammonBoard tablero = (BackgammonBoard)s;
			AccionBackgammon accion = (AccionBackgammon)a;
			
			BackgammonBoard nuevoTablero = accion.Aplicar(tablero);
			
//			System.out.println(tablero.NumeroDeJugada() + ". " + tablero.toString() + "		" + accion.toString() + "		" + nuevoTablero.toString());
			
			return nuevoTablero;
		}
	}
	
}
