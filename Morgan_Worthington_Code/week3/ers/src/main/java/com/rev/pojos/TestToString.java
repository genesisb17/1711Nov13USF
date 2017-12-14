package com.rev.pojos;

public class TestToString {
	public static void main(String[] args) {
		//	User u=new User();
		//	u.setId(5);
		//	u.setEmail("something@something.com");
		//	u.setFn("Joe");
		//	u.setLn("Smith");
		//	u.setUsername("a lone traveler");
		//	u.setPassword("atrickypassword");
		//	u.setRole(2);
		//	System.out.println(u.toString());
		Reimbursement r=new Reimbursement();
		r.setAmount(5);
		r.setAuthor(23);
		r.setResolver(25);
		r.setId(15);
		r.setStatusId(3);
		r.setTypeId(4);
		r.setDescription("get money get paid");
		r.setReceipt("supposed to be a picture");
		r.setResolved("no");
		r.setSubmitted("yes");

		System.out.println(r.toString());
	}
}