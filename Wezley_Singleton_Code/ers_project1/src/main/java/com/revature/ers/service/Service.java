package com.revature.ers.service;

import java.util.ArrayList;

import com.revature.ers.dao.ReimbursementDAO;
import com.revature.ers.dao.ReimbursementDAOImpl;
import com.revature.ers.dao.UserDAO;
import com.revature.ers.dao.UserDAOImpl;
import com.revature.ers.dto.DetailedReimbursement;
import com.revature.ers.pojos.Reimbursement;
import com.revature.ers.pojos.User;

public class Service {
	
	private static UserDAO userDao = new UserDAOImpl();
	private static ReimbursementDAO reimbursementDao = new ReimbursementDAOImpl();
	
	public User createNewUser(User newUser) {
		return userDao.addUser(newUser);
	}
	
	public User verifyUserCredentials(String username, String password) {
		User loggedInUser = null;
		User targetUser = userDao.getUserByUsername(username.toLowerCase());
		
		if(targetUser.getPassword().equals(password)) {
			loggedInUser = targetUser;
		}
		return loggedInUser;
	}
	
	public boolean isUsernameAvailable(String username) {
		for(User user : userDao.getAllUsers()) {
			if(user.getUsername().equals(username)) {
				return false;
			}
		}
		return true;
	}
	

	public boolean isEmailAddressAvailable(String emailAddress) {
		for(User user : userDao.getAllUsers()) {
			if(user.getEmailAddress().equals(emailAddress)) {
				return false;
			}
		}
		return true;
	}
	
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}
	
	public User updateUsernameById(int id, String updatedUsername) {
		return userDao.updateUsernameByUserId(id, updatedUsername);
	}
	
	public User updateEmailAddressById(int id, String updatedEmailAddress) {
		return userDao.updateEmailAddressByUserId(id, updatedEmailAddress);
	}
	
	public User updatePasswordById(int id, String updatedPassword) {
		return userDao.updatePasswordByUserId(id, updatedPassword);
	}
	
	public Reimbursement openNewReimbursementTicket(Reimbursement newReimbursement) {
		return reimbursementDao.addReimbursement(newReimbursement);
	}
	
	public Reimbursement updatePendingReimbursementTicket(Reimbursement updatedReimbursement) {
		System.out.println("In updatePendingReimbursementTicket()");
		System.out.println(updatedReimbursement.getReimbursementId());
		return reimbursementDao.updateReimbursement(updatedReimbursement.getReimbursementId(), updatedReimbursement);
	}
	
	public ArrayList<Reimbursement> getPendingReimbursementsByAuthorId(int authorId) {
		return reimbursementDao.getPendingReimbursementsByAuthorId(authorId);
	}
	
	public ArrayList<DetailedReimbursement> getAllPendingReimbursements() {
		ArrayList<Reimbursement> pendingReimbursements = reimbursementDao.getReimbursementByStatusId(3);
		ArrayList<DetailedReimbursement> pendingReimbursements_detailed = new ArrayList<DetailedReimbursement>();
		
		for(Reimbursement pendingReimbursement : pendingReimbursements) {
			
			DetailedReimbursement reimbursement_detailed = new DetailedReimbursement();
			reimbursement_detailed.setReimbursementId(pendingReimbursement.getReimbursementId());
			reimbursement_detailed.setAmount(pendingReimbursement.getAmount());
			reimbursement_detailed.setTimeResolved(pendingReimbursement.getTimeResolved());
			reimbursement_detailed.setDescription(pendingReimbursement.getDescription());
			reimbursement_detailed.setReceipt(pendingReimbursement.getReceipt());
			
			User author = userDao.getUserById(pendingReimbursement.getAuthorId());
			reimbursement_detailed.setAuthor(author.getFirstName() + " " + author.getLastName());
			
			switch(pendingReimbursement.getTypeId()) {
			case 1:
				reimbursement_detailed.setType("Lodging");
				break;
			case 2:
				reimbursement_detailed.setType("Travel");
				break;
			case 3:
				reimbursement_detailed.setType("Food");
				break;
			case 4:
				reimbursement_detailed.setType("Other");
				break;
			}
			
			reimbursement_detailed.setStatus("Pending");
			
			pendingReimbursements_detailed.add(reimbursement_detailed);
		}
		
		/*return pendingReimbursements;*/
		return pendingReimbursements_detailed;
	}
	
	public void closeOpenTicket(int reimbursementId) {
		reimbursementDao.closeReimbursement(reimbursementId);
		System.out.println("[LOG] - Reimbursement, id: " + reimbursementId + ", successfully closed!");
	}
	
	public Reimbursement getReimbursementById(int reimbursementId) {
		return reimbursementDao.getReimbursementById(reimbursementId);
	}
	
	public DetailedReimbursement getDetailedReimbursementById(int reimbursementId) {
		Reimbursement reimb = reimbursementDao.getReimbursementById(reimbursementId);
		DetailedReimbursement reimb_detailed = new DetailedReimbursement();
		reimb_detailed.setReimbursementId(reimb.getReimbursementId());
		reimb_detailed.setAmount(reimb.getAmount());
		reimb_detailed.setTimeResolved(reimb.getTimeResolved());
		reimb_detailed.setDescription(reimb.getDescription());
		reimb_detailed.setReceipt(reimb.getReceipt());
		
		User author = userDao.getUserById(reimb.getAuthorId());
		if(author.getUserId() == 1) { reimb_detailed.setAuthor("Admin");}
		else { reimb_detailed.setAuthor(author.getFirstName() + " " + author.getLastName()); }
		
		User resolver = userDao.getUserById(reimb.getResolverId());
		if(resolver.getUserId() == 1) { reimb_detailed.setResolver("Admin"); } 
		else { reimb_detailed.setResolver(resolver.getFirstName() + " " + resolver.getLastName()); }
		
		switch(reimb.getTypeId()) {
		case 1:
			reimb_detailed.setType("Lodging");
			break;
		case 2:
			reimb_detailed.setType("Travel");
			break;
		case 3:
			reimb_detailed.setType("Food");
			break;
		case 4:
			reimb_detailed.setType("Other");
			break;
		}
		
		switch(reimb.getStatusId()) {
		case 1:
			reimb_detailed.setStatus("Approved");
			break;
		case 2:
			reimb_detailed.setStatus("Denied");
			break;
		case 3:
			reimb_detailed.setStatus("Pending");
			break;
		case 4:
			reimb_detailed.setStatus("Closed");
			break;
		}
		
		return reimb_detailed;
	}
	
	public Reimbursement updateReimbursementStatusById(int reimbId, int resolverId, int statusId) {
		Reimbursement reimb = reimbursementDao.updateReimbursementStatusById(reimbId, resolverId, statusId);
		return reimb;
	}
	
	public ArrayList<DetailedReimbursement> getResolvedUserReimbursements(int authorId) {
		ArrayList<Reimbursement> resolvedReimbursements = new ArrayList<Reimbursement>();
		for(Reimbursement reimb : reimbursementDao.getAllReimbursements()) {
			if (reimb.getStatusId() != 3) {
				if(reimb.getAuthorId() == authorId) {
					resolvedReimbursements.add(reimb);
				}
			}
		}
		
		ArrayList<DetailedReimbursement> resolvedReimbursements_detailed = new ArrayList<DetailedReimbursement>();
		for(Reimbursement resolvedReimb : resolvedReimbursements) {
			DetailedReimbursement reimbursement_detailed = new DetailedReimbursement();
			reimbursement_detailed.setReimbursementId(resolvedReimb.getReimbursementId());
			reimbursement_detailed.setAmount(resolvedReimb.getAmount());
			reimbursement_detailed.setTimeResolved(resolvedReimb.getTimeResolved());
			reimbursement_detailed.setReceipt(resolvedReimb.getReceipt());
			reimbursement_detailed.setDescription(resolvedReimb.getDescription());
			
			User resolver = userDao.getUserById(resolvedReimb.getResolverId());
			if(resolver.getUserId() == 1) { reimbursement_detailed.setResolver("Admin"); } 
			else { reimbursement_detailed.setResolver(resolver.getFirstName() + " " + resolver.getLastName()); }
			
			switch(resolvedReimb.getTypeId()) {
			case 1:
				reimbursement_detailed.setType("Lodging");
				break;
			case 2:
				reimbursement_detailed.setType("Travel");
				break;
			case 3:
				reimbursement_detailed.setType("Food");
				break;
			case 4:
				reimbursement_detailed.setType("Other");
				break;
			}
			
			switch(resolvedReimb.getStatusId()) {
			case 1:
				reimbursement_detailed.setStatus("Approved");
				break;
			case 2:
				reimbursement_detailed.setStatus("Denied");
				break;
			case 4:
				reimbursement_detailed.setStatus("Closed");
				break;
			}
			
			resolvedReimbursements_detailed.add(reimbursement_detailed);
		}
		
		/*return resolvedReimbursements;*/
		return resolvedReimbursements_detailed;
	}
}
