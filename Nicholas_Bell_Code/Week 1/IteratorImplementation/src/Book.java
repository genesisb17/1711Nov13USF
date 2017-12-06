
public class Book {

	public String name;
	public String isbn;
	
	public Book(String name, String isbn) {
		this.name = name;
		this.isbn = isbn;
	}
	
	public String toString() {
		return ("Title: " + name + "\n ISBN: " +
	isbn + "\n");
	}
	
}
