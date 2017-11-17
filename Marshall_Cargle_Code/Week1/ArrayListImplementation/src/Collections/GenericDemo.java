package Collections;

public class GenericDemo<E> {
	private E thisGeneric;

	public GenericDemo(E thisGeneric) {
		this.thisGeneric = thisGeneric;
	}

	//Basic Get method
	public E getThisGeneric() {
		return thisGeneric;
	}

	//Basic Set method
	public void setThisGeneric(E thisGeneric) {
		this.thisGeneric = thisGeneric;
	}

	//toString for printing messages
	public String toString() {
		return thisGeneric + (" = Generic");
	}
}
