window.onload = function(){
	//loadLanding();
	$('#Home').on('click',loadLanding());
	//$('#profile').on('click', loadProfile);
}

function loadLanding(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			console.log("Alert");
		}
	}
}