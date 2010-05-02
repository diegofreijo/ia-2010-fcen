package ar.uba.dc.ia2010.ej1;

import aima.core.agent.Action;

public class MoverADireccionAction implements Action {
	
	private Directions direccion;

	public MoverADireccionAction(Directions direccion) {
		super();
		this.direccion = direccion;
	}

	public Directions getDireccion() {
		return direccion;
	}

	public boolean isNoOp() {
		return false;
	}
	
	public String toString() {
		return "Mover direccion " + direccion.name();
	}

}
