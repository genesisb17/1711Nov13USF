/**
 * 
 */

function getPokemon(){
	//
	var id = document.getElementById("id").value;
	console.log(`Sending Poke no. ${id}`);//this is the other single quote(top left keyboard)
	
	//USING XMLHttpRequest OBJECT. FOUR STEPS
	//Step 1. create XHR; 
	var xhr = new XMLHttpRequest();
	
	//Step 2 function to handle ready state change of the response; callback function
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			pokemon = JSON.parse(xhr.responseText);//returns a whole object
			setValues(pokemon);
		}
	}

	//Step 3 Open Request
	//xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${id}`, true);
															//true sends request asynchronously
	xhr.open("GET", `https://swapi.co/api/people/${id}`,true);
	//Step 4
	xhr.send();
}

function setValues(pokemon){
	document.getElementById("name").innerHTML = pokemon.name;
}



window.onload = function(){
	document.getElementById("submit").addEventListener("click", getPokemon);
}
