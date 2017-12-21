package com.ex.beans;

public class User {
	private int USER_ID;
	private String FIRSTNAME;
	private String LASTNAME;
	private String EMAIL;
	private String PNUMBER;
	private String PASSWORD;
	private int Role;

	public User() {
	}

	public User(int uSER_ID, String fIRSTNAME, String lASTNAME, String eMAIL, String pNUMBER, String pASSWORD,
			int role) {
		super();
		USER_ID = uSER_ID;
		FIRSTNAME = fIRSTNAME;
		LASTNAME = lASTNAME;
		EMAIL = eMAIL;
		PNUMBER = pNUMBER;
		PASSWORD = pASSWORD;
		Role = role;
	}

	public int getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getFIRSTNAME() {
		return FIRSTNAME;
	}

	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}

	public String getLASTNAME() {
		return LASTNAME;
	}

	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPNUMBER() {
		return PNUMBER;
	}

	public void setPNUMBER(String pNUMBER) {
		PNUMBER = pNUMBER;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public int getRole() {
		return Role;
	}

	public void setRole(int role) {
		Role = role;
	}

	@Override
	public String toString() {
		return "User [USER_ID=" + USER_ID + ", FIRSTNAME=" + FIRSTNAME + ", LASTNAME=" + LASTNAME + ", EMAIL=" + EMAIL
				+ ", PNUMBER=" + PNUMBER + ", PASSWORD=" + PASSWORD + ", Role=" + Role + "]";
	}

}
