package ar.uba.dc.ia2010.tp1ej2;

import java.util.ArrayList;

public class Bloque {
	// esto es un bloque de elementos en orden creciente
	public ArrayList<Integer> elementos;
	public dirBloque dir = dirBloque.INDEFINIDA;
	public int desde, hasta;

	public String toString()
	{
		return elementos.toString();
	}

	public Bloque( ArrayList<Integer> elArray, int desdeArg, int hastaArg )
	{
		elementos = new ArrayList<Integer>();
		
		if( desdeArg > hastaArg )
		{
			dir = dirBloque.DECRECIENTE;
			desde = hastaArg;
			hasta = desdeArg;
		}
		else
		{
			dir = dirBloque.CRECIENTE;
			desde = desdeArg;
			hasta = hastaArg;
		}
		for( ; desde <= hasta; desde++ )
		{
			elementos.add( elArray.get(desde) );
		}
	}
	
	public Integer traerElementosEnOrdenCreciente( int i )
	{
		if( dir != dirBloque.DECRECIENTE )
		{
			return elementos.get(i);
		}
		return elementos.get(elementos.size()-1-i);
	}

	public static ArrayList<Bloque> dividirEnBloquesOrdenados( ArrayList<Integer> elArray )
	{
		ArrayList<Bloque> result = new ArrayList<Bloque>();
		if( elArray.size() == 0 )
			return result;

		int inicioBloque = 0;
		for( int i = 1; i < elArray.size(); i++ )
		{
			if( elArray.get(i-1) > elArray.get(i) )
			{
				result.add( new Bloque(elArray, inicioBloque, i-1) );
				inicioBloque = i;
			}
		}
		result.add( new Bloque(elArray, inicioBloque, elArray.size() - 1) );

		return result;
	}
	public enum dirBloque { INDEFINIDA, CRECIENTE, DECRECIENTE }

	public static ArrayList<Bloque> dividirEnBloquesOrdenados2Dirs( ArrayList<Integer> elArray )
	{
		ArrayList<Bloque> result = new ArrayList<Bloque>();
		if( elArray.size() == 0 )
			return result;

		dirBloque dir = dirBloque.INDEFINIDA;
		int inicioBloque = 0;

		for( int i = 1; i < elArray.size(); i++ )
		{
			if( elArray.get(i-1) < elArray.get(i) )
			{
				switch( dir )
				{
				case INDEFINIDA:
					dir = dirBloque.CRECIENTE;
					break;
				case CRECIENTE:
					break;
				case DECRECIENTE:
					result.add( new Bloque(elArray,i-1,inicioBloque) );
					dir = dirBloque.INDEFINIDA;
					inicioBloque = i;
					break;
				}
			}
			else if( elArray.get(i-1) > elArray.get(i) )
			{ // nos encontramos con algo mas chico
				switch( dir )
				{
				case INDEFINIDA:
					dir = dirBloque.DECRECIENTE;
					break;
				case CRECIENTE:
					result.add( new Bloque(elArray,inicioBloque,i-1) );
					dir = dirBloque.INDEFINIDA;
					inicioBloque = i;
					break;
				case DECRECIENTE:
					break;
				}
			}
		}
		switch( dir )
		{
		case INDEFINIDA:
		case CRECIENTE:
			result.add( new Bloque(elArray,inicioBloque,elArray.size()-1) );
			break;
		case DECRECIENTE:
			result.add( new Bloque(elArray,elArray.size()-1,inicioBloque) );
			break;
		}

		return result;
	}

	public static ArrayList<Integer> intercalar( Bloque b1, Bloque b2 )
	{
		ArrayList<Integer> resultArray = new ArrayList<Integer>();
		int indice1 = 0;
		int indice2 = 0;

		while( b1.elementos.size() > indice1 || b2.elementos.size() > indice2 )
		{
			if( b1.elementos.size() == indice1 )
			{
				resultArray.add( b2.traerElementosEnOrdenCreciente(indice2) );
				indice2++;
				continue;
			}
			if( b2.elementos.size() == indice2 )
			{
				resultArray.add( b1.traerElementosEnOrdenCreciente(indice1) );
				indice1++;
				continue;
			}
			if( b1.traerElementosEnOrdenCreciente(indice1) >
			   b2.traerElementosEnOrdenCreciente(indice2) )
			{
				resultArray.add( b2.traerElementosEnOrdenCreciente(indice2) );
				indice2++;
				continue;
			}
			else
			{
				resultArray.add( b1.traerElementosEnOrdenCreciente(indice1) );
				indice1++;
				continue;
			}
		}
		return resultArray;
	}
}
