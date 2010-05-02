package ar.uba.dc.ia2010.ej1;

import java.util.HashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;

public class ActionsFunctionImpl implements ActionsFunction {

	@Override
	public Set<Action> actions(Object s) {
		
		Set<Action> set = new HashSet<Action>();
		int[] state = (int[])s;
		int zeroPos = Utils.zeroPosition(state);
		if (zeroPos == -1)
			throw new RuntimeException("No esta el cero");
		
		// Puede Moverse al norte?		
		if (zeroPos > 2)
			// si cero noesta en la primera fila puede moverse al norte
			set.add(new MoverADireccionAction(Directions.Norte));
		
		// Puede Moverse al sur?
		if (zeroPos < 6)
			// si cero no esta en la ultima fila puede moverse al sur
			set.add(new MoverADireccionAction(Directions.Sur));
	
		// Puede Moverse al oeste?
		if (zeroPos%3!=0)
			// si cero no esta en la columna de la izquierda, o sea fuera de las posiciones 0, 3 o 6 
			// puede moverse al oeste
			set.add(new MoverADireccionAction(Directions.Oeste));

		// Puede Moverse al este?
		if (zeroPos%3!=2)
			// si cero no esta en la columna de la derecha, o sea fuera de las posiciones 2, 5 u 8 
			// puede moverse al este
			set.add(new MoverADireccionAction(Directions.Este));
		
		return set;

	}


	
	

}
