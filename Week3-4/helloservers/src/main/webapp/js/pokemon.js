/**
 * Understanding AJAX
 */

var pokemon;

function getPokemon(){
	
	var id = document.getElementById("id").value;
	console.log(`Sending Poke no. ${id}`);
	
	//USING XMLHttpRequest OBJECT. FOUR STEPS
	//Step 1. create XHR; https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
	var xhr = new XMLHttpRequest();
	
	//Step 2. function to handle ready state change of the response; callback function
	xhr.onreadystatechange = function(){
		console.log(xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			//JSON: https://spring.io/understanding/JSON
			pokemon = JSON.parse(xhr.responseText);
			setValues(pokemon);
		}
	}
	//Step 3. Open
	xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${id}`, true);
//	xhr.open("GET", `https://swapi.co/api/people/${id}`, true); 
									//true sends request asynchronously
	//getting a CORS error when sending? try https instead of http: https://www.instantssl.com/ssl-certificate-products/https.html
	//Step 4. Send
	xhr.send(); 
}

function setValues(pokemon){
	document.getElementById("name").innerHTML = pokemon.name;
}



window.onload = function(){
	console.log("window loaded");
	document.getElementById("submit").addEventListener("click", getPokemon);
}