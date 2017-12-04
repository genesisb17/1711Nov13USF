/**
 *	previously app.js 
 */
function register(){
	var fn=$('#fn').val();
	var ln=$('#ln').val();
	var uname=$('#username').val();
	var pass=$('#pass').val();
	//add password validation and second input confirmation?
	
	var user={
			id:0,
			firstname:fn,
			lastname: ln,
			username: uname,
			password:pass
	}
	
	
}