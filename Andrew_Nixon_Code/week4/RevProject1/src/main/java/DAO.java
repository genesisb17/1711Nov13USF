

import java.util.ArrayList;

import com.rev.dtos.ManagerReimbursementsDTO;
import com.rev.pojos.ERSUser;
import com.rev.pojos.Reimbursement;
import com.rev.pojos.ReimbursementStatus;
import com.rev.pojos.ReimbursementType;
import com.rev.pojos.UserRole;

public interface DAO {
	
	public ERSUser getUserByID(int userID);
	public ArrayList<ERSUser> getUsers();
	public Reimbursement getReimbursementByID(int rID);
	public ArrayList<Reimbursement> getReimbursements();
	public ReimbursementStatus getStatusByID(int statusID);
	public ReimbursementType getTypeByID(int typeID);
	public UserRole getRoleByID(int roleID);
	public ERSUser addUser(ERSUser ersUser);
	public Reimbursement addReimbursement(Reimbursement reimbursement);
	public ERSUser getERSUserByUsername(String username);
	public ERSUser getERSUserByUsernameAndPassword(String username, String password);
	public ArrayList<Reimbursement> getReimbursementsByAuthorID(int authorID);
	public ArrayList<Reimbursement> getReimbursementsByStatus(int i);
	public Reimbursement resolveReimb(int reimbID, int resolverID, int statusID);
	public ArrayList<ManagerReimbursementsDTO> getManagerReimbursements();


}
