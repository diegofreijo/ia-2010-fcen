package ar.uba.dc.ia2010.tp1ej2;

import java.util.ArrayList;

public class Tp1ej2State {
	public ArrayList<Integer> elementos;
	public ArrayList<Bloque> bloques = null;
	
	public Tp1ej2State( ArrayList<Integer> e )
	{
		elementos = e;
	}
	public Tp1ej2State( ArrayList<Integer> e, ArrayList<Bloque> b )
	{
		elementos = e;
		bloques = b;
	}
	
	public boolean isGoal()
	{
		for( int i = 0; i < elementos.size() - 1; i++ )
		{
			if( elementos.get(i) > elementos.get(i+1) )
				return false;
		}
		return true;
	}

	public boolean equals( Object obj )
	{
		return (obj instanceof Tp1ej2State) &&
			((Tp1ej2State)obj).elementos.equals( elementos );
	}
	public int hashCode()
	{
		return elementos.hashCode();
	}
}
