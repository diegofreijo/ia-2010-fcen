package ar.uba.dc.ia2010.tp1ej2;

import aima.core.agent.Action;

public class Tp1ej2Action implements Action {

	public Tp1ej2State newState;
	private double cost = 2.0;
	private String extraString = "";

	public Tp1ej2Action( Tp1ej2State resultState )
	{
		newState = resultState;
	}
	public Tp1ej2Action( Tp1ej2State resultState, double costArg )
	{
		newState = resultState;
		cost = costArg;
	}
	public Tp1ej2Action( Tp1ej2State resultState, double costArg, String extraS )
	{
		newState = resultState;
		cost = costArg;
		extraString = extraS;
	}

	public String toString()
	{
		return extraString + newState.elementos.toString();
	}
	
	public double getCost()
	{
		return cost;
	}

	@Override
	public boolean isNoOp() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean equals( Object obj )
	{
		return (obj != null) && (obj instanceof Tp1ej2Action) &&
		    ((Tp1ej2Action)obj).cost == cost &&
			((Tp1ej2Action)obj).newState.equals(newState);
	}
	public int hashCode()
	{
		return newState.hashCode();
	}
}
