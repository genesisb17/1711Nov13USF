package com.revature.dto;

import com.revature.pojos.Users;

public class PageInfoDTO {

	private Users user;
	private String page;
	
	public PageInfoDTO() {}

	public PageInfoDTO(Users user, String page) {
		super();
		this.user = user;
		this.page = page;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "PageInfoDTO [user=" + user + ", page=" + page + "]";
	}
	
}
