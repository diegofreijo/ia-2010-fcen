package ar.uba.dc.ia2010.ej1;

public class Utils {

	public static int zeroPosition(int[] state) {
		for (int i = 0; i < state.length; i++)
			if (state[i]==0)
				return i;
		return -1;
	}



}
