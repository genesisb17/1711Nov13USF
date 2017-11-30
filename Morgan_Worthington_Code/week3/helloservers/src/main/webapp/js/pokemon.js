/**
 * Understanding AJAX
 */


function getPokemon(){
	var id = document.getElementById("id").value;
	console.log(`Sending Poke no. ${id}`);
	
	//USING XMLHttpRequest OBJECT
	//Step 1. Create XHR //url in master branch
	var xhr = new XMLHttpRequest();
	
	//Step 2. function to handle ready state change of the response; callback function
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status == 200){
			var pokemon = JSON.parse(xhr.responseText);
			console.log(pokemon.name);
			//set values method
			setValues(pokemon);
		}
	}
	
	//Step 3. Open
	xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${id}`,true);
									//true sends request asynchronously
	//xhr.open("GET",`https://swapi.co/api/people/${id}`,true);
	//Step 4. Send
	xhr.send();
	
}

function setValues(pokemon){
	document.getElementById("name").innerHTML = pokemon.name;
}

window.onload = function(){
	document.getElementById("submit").addEventListener("click",getPokemon);
}