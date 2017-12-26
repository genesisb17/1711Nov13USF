package com.ERS.pojos;

import java.util.ArrayList;

import com.ERS.pojos.*;

public class DTO {
	private User user;
	private ArrayList<ReimbRow> tablerows;
	
	public DTO() {}
	
	public DTO(User user, ArrayList<ReimbRow> tablerows) {
		super();
		this.user = user;
		this.tablerows = tablerows;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<ReimbRow> getTablerows() {
		return tablerows;
	}

	public void setTablerows(ArrayList<ReimbRow> tablerows) {
		this.tablerows = tablerows;
	}


	
}
