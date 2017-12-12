


//perhaps a reload button to check if admin or another user has changed ticket stsus
$('document').ready(function(){table()});


function table(){

	$.get( "viewTable", function( data ) {
		  //alert( "Load was performed." );
		  var dataSet=[];
		  for(let i = 0 ; i < data.length;i++){
		  dataSet[i]=[
		              statusConv(data[i].status)
		              ,typeConv(data[i].type)
		              ,String("$"+data[i].amount.toFixed(2))
		              ,data[i].submitted
		              ,data[i].resolved
		              ,data[i].desc];
		  }
		  console.log(data);
		  
		  table1(dataSet);
		  console.log("after 2table1");

		});
/*	
	var xhr = new XMLHttpRequest(); 	
	console.log(xhr.readyState);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback tables" + xhr.responseText);
			var accounts=JSON.parse(xhr.responseText);
			
		}
	};
	xhr.open("POST","viewTable", true);
	console.log(xhr.readyState);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	console.log("AFTER HEADER " + xhr.readyState);
	//xhr.send(json);
*/
};


function statusConv(status){
	switch (status) {
		case 0:
			return("pending");
		break;
		case 1:
			return("approved");
		case 2:
			return("Denied");
	}
	
};
function typeConv(status){
	switch (status) {
		case 0:
			return("lodging");
		break;
		case 1:
			return("travel");
		case 2:
			return("food");
		case 3:
			return("other");
	}
	
};

function table1(dataSet){
console.log(dataSet);
$('#example').DataTable( {
    data: dataSet,
    columns: [
    { title: "Status" },
    { title: "Type" },
    { title: "Amount" },
    { title: "Submitted" },
    { title: "Resolved" },
    { title: "Desc" }
    ]
    } );
};

/**
 * table code 
 */
