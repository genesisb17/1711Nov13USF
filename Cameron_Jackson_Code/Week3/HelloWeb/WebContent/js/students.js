/**
 * Students js functions
 */
var id = 50;
function add() {
	// get element values
	id++;
	var name = document.getElementById("name").value;
	var major = document.getElementById("major").value;
	
	// create row
	var row = document.createElement("tr");
	
	// create row cells
	var cell1 = document.createElement("td");
	var cell2 = document.createElement("td");
	var cell3 = document.createElement("td");
	
	// append cells to row
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	
	// add info to cells
	cell1.innerHTML = id;
	cell2.innerHTML = name;
	cell3.innerHTML = major;
	
	// append row to table
	document.getElementById("students").appendChild(row);
}

// add event listener
document.getElementById("add").addEventListener("click", add, false);