package ar.uba.dc.ia2010.ej1;

import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.eightpuzzle.ManhattanHeuristicFunction;
import aima.core.search.framework.HeuristicFunction;

public class NilssonSequenceScoreHeuristic implements HeuristicFunction {

	private int[] array = { 1, 2, 3, 8, 0, 4, 7, 6, 5 };

	@Override
	public double h(Object state) {
		ManhattanHeuristicFunction man = new ManhattanHeuristicFunction();
		EightPuzzleBoard board = (EightPuzzleBoard)state;
		int s = 0;
		if (board.getBoard()[4] != 0)
			s++;

		for (int i = 0; i < board.getBoard().length; i++) {
			int num = board.getBoard()[i];
			int posNum = 0;
			for (int j = 0; j < array.length; j++)
				if (array[j]==num)
					posNum=j;
			// TODO FALTA CALCULAR LA POSICION DEL SIGUIENTE CON RESPECTO A LAS AGUJAS DEL RELOJ
		}
		return 0;
	}

}
