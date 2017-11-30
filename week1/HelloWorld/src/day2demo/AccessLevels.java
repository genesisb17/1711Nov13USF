package day2demo;

/*
 * outer classes can only be public or package level access. 
 * 
 */
public class AccessLevels {
	
	//all levels can be applied to members
	public int pub;
	protected int protect;
	int pack;
	int priv;
	
	// constructors are usually public but can be private, will go into when we use other access mods
	public AccessLevels(){
	}
	
	
	protected class ProtectedInner{
		
	}
	
	private class PrivateInner{
		
	}

}


class PackageClass{
		
}

