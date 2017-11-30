
count = 1000;
function add() {
	// Get input values
	var name = document.getElementById("name").value;
	var major = document.getElementById("major").value;
	
	// Create row
	var row = document.createElement("tr");
	
	
	//create row cells
	var cell1 = document.createElement("td");
	var cell2 = document.createElement("td");
	var cell3 = document.createElement("td");
	
	// Append cells to row
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);

	cell1.innerHTML = count++;
	cell2.innerHTML = name;
	cell3.innerHTML = major;
	
	// Append row to table
	document.getElementById("students").appendChild(row);

}

document.getElementById("add").addEventListener("click", add, false);