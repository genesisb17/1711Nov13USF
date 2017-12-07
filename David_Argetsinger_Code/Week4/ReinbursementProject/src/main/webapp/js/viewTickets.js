


window.onload = function(){
	
	var json = JSON.stringify(toSend);
	console.log(json);
	
	var xhr = new XMLHttpRequest(); 	
	console.log(xhr.readyState);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback" + xhr.responseText);
		}
	}
}


/**
 * table code 
 */
$(document).ready(function() {
    $('#example').DataTable( {
        data: user,
        columns: [
        { title: "username" },
        { title: "password" },
        { title: "lastname" },
        { title: "name" },
        { title: "email" },
        { title: "id" },
        { title: "role" }
        ]
        } );
} );
