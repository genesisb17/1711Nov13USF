/**
 * 
 */

var increment = function(x){return function(){return x++;}}(0);


function add(){
	var name = document.getElementById("name").value;
	var major = document.getElementById("major").value;
	
	var row = document.createElement("tr");
	
	var cell1 = document.createElement("td");
	var cell2 = document.createElement("td");
	var cell3 = document.createElement("td");
	
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	
	cell1.innerHTML = increment();
	cell2.innerHTML = name;
	cell3.innerHTML = major;
	
	document.getElementById("students").appendChild(row);	
}

window.onload = function(){
	document.getElementById("add").addEventListener("click", add, false);
	incrementer = increment();
}