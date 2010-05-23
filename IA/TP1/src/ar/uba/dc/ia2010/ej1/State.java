package ar.uba.dc.ia2010.ej1;

public class State {

	int[] array;

	public State(int[] array) {
		super();
		this.array = array;
	}

	public boolean equals(Object s) {
		if (!s.getClass().equals(State.class))
			return false;
		State state = (State)s;
		for (int i = 0; i < state.getArray().length; i++)
			if (state.getArray()[i] != this.array[i])
				return false;
		return true;
	}

	public int[] getArray() {
		return array;
	}


}
