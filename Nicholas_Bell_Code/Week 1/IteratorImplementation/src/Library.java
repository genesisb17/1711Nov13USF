import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library /* implements Iterable<Book>*/{

	List<Book> available;

	public Library() {
		available = new ArrayList<Book>();
	}
	
	public void addBook(Book b) {
		available.add(b);
	}
	/*
	@Override
	public Iterator<Book> iterator() {
		// TODO Auto-generated method stub
		return (Iterator<Book>) new LibraryIter();
	}
	
	class LibraryIter implements Iterator<Book>{
		int index = 0;

		@Override
		public boolean hasNext() {
			if(index >= available.size()) {
				return false;
			}else return true;
		}

		@Override
		public Book next() {
			// TODO Auto-generated method stub
			return available.get(index++);
		}
		
		@Override
		public void remove() {
			available.remove(--index);
		}
		
	}*///delete for demo
	
	public static void main(String[] args) {
		Book b1 = new Book("Paradise Lost", "11111");
		Book b2 = new Book("The Bible", "11112");
		Book b3 = new Book("Ender's Game", "11113");
		
		Library inStock = new Library();
		
		inStock.addBook(b1);
		inStock.addBook(b2);
		inStock.addBook(b3);
		
		System.out.println("Display:");
		for (Book aBook : inStock) {
			System.out.println(aBook);
		}
		
	}

}
