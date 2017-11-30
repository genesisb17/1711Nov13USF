/**
 * Understanding AJAX
 */

function getPokemon(){
	
	var id = document.getElementById("id").value;
	console.log(`Sending Poke No. ${id}`);

	//using XMLHttpRequest OBJECT. Four Steps
	//Step 1: Create XHR
	var xhr = new XMLHttpRequest();

	//Step 2: function to handle ready state change of response;
	//callback function
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			var pokemon = JSON.parse(xhr.responseText);
			console.log(pokemon.name);
			//set values method
			setValues(pokemon);
		}

		
	}
	//Step 3:
	xhr.open("GET",`https://swapi.co/api/people/${id}`,true);
												//true sends request asynchronously
	//step 4:
	xhr.send();
	
}


window.onload = function(){
	
	document.getElementById("submit").addEventListener("click",getPokemon);
	
}


function setValues(pokemon){

	document.getElementById("name").innerHTML = pokemon.name;
	
}


