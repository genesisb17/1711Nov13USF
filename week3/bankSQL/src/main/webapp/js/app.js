/**
 * 
 */

window.onload = function(){
	$('#login').on('click',login);
	$('#register').on('click',register);

}

function loadHome(){
	loadView("getHomeView");
}

function loadProfile(){
	var xhr= new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(this.readyState==4 &&this.status=200){
			document.getElementById('view').innrHTML=xhr.responseText;
			var user=getUserInfo();
			$("#name").html(user.firstname);
		}
	}
}

function loadView(page){
	var xhr= new XMLHttpRequest();
	xhr.onreadstatechange= function(){
		if(xhr.readyState==4 && xhr.status==200){
			document.getElementById('view').innerHTML=xhr.responseText;
			$('#name').html("Test");
		}
	}
	console.log("REQUESTING VIEW "+page)
	xhr.open("GET",page,true);
	xhr.send();
};


function	GetUserInfo(){
	var sessionUser;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState=4 && xhr.status=200){
			console.log(xhr.responseText);
			sessionUser=JSON.parse(xhr.responseText);
			
		}
	}
	xhr.open("GET","getUserInfo",true);
	xhr.send();
}