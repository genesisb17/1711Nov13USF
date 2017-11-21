import java.util.ArrayList;
import java.util.Iterator;

public class CoIlectionIterator {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(5);
		arr.add(20);
		arr.add(50);
		Iterator<Integer> it = arr.iterator();
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(it.next());
		}
	}

}
