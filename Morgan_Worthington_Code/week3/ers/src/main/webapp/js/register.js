$("#register").on('click',registerNew);

function registerNew(){
	var fn=$("#firstname").val();
	var ln=$("#lastname").val();
	var email=$("#email").val();
	var username=$("#username").val();
	var password=$("#password").val();
	var role=$("input[name=role]:checked").val();
	console.log(fn+", "+ln+", "+email+", "+username+", "+password+", "+role);
}