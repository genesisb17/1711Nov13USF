/**
 * 
 */
$(document).ready( function () {
    $('#table_id').DataTable();
} );

var userJson="";
var user;
getSessionInfo();
console.log(user.role);

function getSessionInfo(){
	var xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.status=200 && xhr.readyState==4){
			userJson=xhr.responseText;
			user=JSON.parse(userJson);
		}
	}
	xhr.open("GET","getSessionInfo",true);
	xhr.send();
};