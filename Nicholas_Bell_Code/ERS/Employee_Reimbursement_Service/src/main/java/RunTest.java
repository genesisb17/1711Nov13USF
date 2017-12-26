import java.util.ArrayList;

import com.ERS.pojos.ReimbRow;
import com.ERS.pojos.Reimbursement;
import com.ERS.pojos.User;
import com.ERS.service.Service;

public class RunTest {

	public static void main(String[] args) {
		Service service = new Service();
		String test = "jsmith";
		User u = service.getUserbyUN(test);
		ArrayList<ReimbRow> rows = service.getAllTickets();
		for(ReimbRow ticket : rows)
			System.out.println(ticket);
	}

}
