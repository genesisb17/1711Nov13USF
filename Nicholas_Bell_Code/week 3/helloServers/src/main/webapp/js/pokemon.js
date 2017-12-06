/**
 *  Understanding AJAX
 */

//pokemon

var pokemon;

function getPokemon(){
	
	var id = document.getElementById("id").value;
	console.log(`Sending Poke no. ${id}`);
	
	//USING XMLHttpRequest OBJECT. FOUR STEPS
	//Step 1. create XHR; https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
	var xhr = new XMLHttpRequest();
	
	//Step 2. function to handle ready state change of the response; callback function
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			pokemon = JSON.parse(xhr.responseText);
			setValues(pokemon);
		}
	}

	//Step 3. Open
	//xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${id}`, true);
	xhr.open("GET", `https://swapi.co/api/people/${id}`, true); 
	
									//true sends request asynchronously
	//Step 4. Send
	xhr.send(); 
}

function setValues(pokemon){
	document.getElementById("name").innerHTML = pokemon.name;
}



window.onload = function(){
	document.getElementById("submit").addEventListener("click", getPokemon);
}




