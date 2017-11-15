package Collections;

public class GenericDemo<E> {
	private E thisGeneric;

	public GenericDemo(E thisGeneric) {
		this.thisGeneric = thisGeneric;
	}

	public E getThisGeneric() {
		return thisGeneric;
	}

	public void setThisGeneric(E thisGeneric) {
		this.thisGeneric = thisGeneric;
	}

	public String toString() {
		return thisGeneric + (" = Generic.");
	}
}
