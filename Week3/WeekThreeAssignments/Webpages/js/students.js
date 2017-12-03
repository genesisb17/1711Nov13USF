/**
 * Javascript file for Students.html
 */
var idCounter = 0;
function add(){
	//get element values
	idCounter++;
	var name = document.getElementById("nameInput").value;
	var major = document.getElementById("majorInput").value;
	
	//create row in table 
	var row = document.createElement("tr");
	
	
	//create row cells
	
	var cell1=document.createElement("td");
	var cell2=document.createElement("td");
	var cell3=document.createElement("td");
	
	//append cells to row
	
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	
	//add data to cells
	cell1.innerHTML = idCounter;
	cell2.innerHTML = name;
	cell3.innerHTML = major;
	
	//append row to table
	
	document.getElementById("students").appendChild(row);
	
}

document.getElementById("add").addEventListener("click",add,false);