


//perhaps a reload button to check if admin or another user has changed ticket stsus

window.onload = function(){
	//$('#update').on('click', add);
	$('#riembNum').blur(validId);
	$('#update').attr("disabled",true);

}

$('document').ready(function(){
	id=[]; // used to check for valid id's
	table();


});






function validId(){

	var idNum = $(`#riembNum`).val();
//	console.log(" id is : " +  id);
//	console.log("id numb is : " + idNum)
//	console.log(" is it id.includes ? "+ id.some(a=>a==idNum))
	if (id.some(a=>a==idNum)) {
		$(`#amountmessage`).html("uhh vali2d");
		$('#update').attr("disabled",false	);
	}
	else	{
		//console.log("ids"+id);
		$(`#amountmessage`).html("Only a valid request # is accepted");
		$('#update').attr("disabled",true);
	}
}




function update(){
	var id = $(`#riembNum`).val();
	var typ = $(`#type`).val();
	var reimburse = {
			id: id,
			amount: null,
			submitted: null,
			resolved: null, 
			desc: des, 
			receipt:null,
			author:null,
			resolver:null, //needs to be YOU make sure grabbed from session 
			status:null,
			type: typ

	};

	var json = JSON.stringify(reimburse);
	console.log(json);

	var xhr = new XMLHttpRequest();
	console.log(xhr.readyState);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback" + xhr.responseText);
			console.log("i tried, now crie");
		}
	};



	xhr.open("POST","reimbUpd", true); // goes to the register servlet! 
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	console.log("good luck m8 off to the servlet");

}





function table(){

	$.get( "viewAdminTable", function( data ) {
		//alert( "Load was performed." );
		var dataSet=[];
		for(let i = 0 ; i < data.length;i++){

			id.push(data[i].id)
			dataSet[i]=[
			            data[i].id
			            ,statusConv(data[i].status)
			            ,typeConv(data[i].type)
			            ,String("$"+data[i].amount.toFixed(2))
			            ,data[i].author
			            ,data[i].submitted
			            ,data[i].resolved
			            ,data[i].desc];
		}
		console.log(data);

		table1(dataSet);




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
		          { title: "Request#" },
		          { title: "Status" },
		          { title: "Type" },
		          { title: "Amount" },
		          { title: "User#" },
		          { title: "Submitted" },
		          { title: "Resolved" },
		          { title: "Desc" }
		          ]

	}
	


	);
};




