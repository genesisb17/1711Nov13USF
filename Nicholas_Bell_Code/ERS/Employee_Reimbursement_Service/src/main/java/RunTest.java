import com.ERS.pojos.User;
import com.ERS.service.Service;

public class RunTest {

	public static void main(String[] args) {
		Service service = new Service();
		String test = "admin";
		User u = service.getUser(test);
		System.out.println(u);
		Integer testi = null;
		testi = 1;
		System.out.println(testi);
	}

}
