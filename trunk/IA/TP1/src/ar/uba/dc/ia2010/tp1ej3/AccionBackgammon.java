package tp1ej3;

import aima.core.agent.Action;

public class AccionBackgammon implements Action
{
	private int desde = -1;
	private int hasta = -1;
	private int dado = -1;
	
	@Override
	public boolean isNoOp()
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString()
	{
		return "(" + dado + ")" + desde + "->" + hasta;
	}
	
	public AccionBackgammon(int desde, int hasta, int dado)
	{
		this.desde = desde;
		this.hasta = hasta;
		this.dado = dado;
	}
	
	public BackgammonBoard Aplicar(BackgammonBoard tablero)
	{
		if (this.isNoOp())
		{
			return tablero;
		}
		else
		{
			BackgammonBoard nuevoTablero = new BackgammonBoard(tablero);
			nuevoTablero.MoverFicha(desde, hasta);
			return nuevoTablero;
		}
	}
	
}
