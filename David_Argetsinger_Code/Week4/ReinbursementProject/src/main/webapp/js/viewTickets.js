
$('document').ready(function(){table()});

window.onload = function(){
	setTimeout(function(){takeyotime(); }, 300); // neeedd to avoid not LOADING 
	//can argue that i should just remove switch statement truthfully. 
	// but on that note. it works.
}


function takeyotime(){
	$(`#amountmessage`).hide();
	$('#add').on('click', add);
	$('#amount').on('keyup',validAmount);
	$('#add').attr("disabled",true);	
}

//validation for money amount submitted, possible to switch for number text inut to check for numbers 
function validAmount(){
	var amount = $(`#amount`).val();
	if (isNaN(amount) || amount < 1 || amount =="") {

		$(`#amountmessage`).show();
		$(`#amountmessage`).html("only positive and real numbers are accepted");
		$('#add').attr("disabled",true);
		return false;
	}else	{

		$(`#amountmessage`).hide();
		$('#add').attr("disabled",false);
		return true;
	}
}



//creates and sends a new reimb 
function add(){
	if(validAmount()==false){
		return;	
	} // to get the sneaky ones
	var des = $(`#desc`).val();
	var amoun = $(`#amount`).val();
	var typ = $(`#type`).val();
	var reimburse = {
			id: 0,
			amount: amoun,
			submitted: null,
			resolved: null, 
			desc: des, 
			receipt:null,
			author:null,
			resolver:null,
			status:null,
			type: typ

	};

	var json = JSON.stringify(reimburse);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			window.location.replace('members.html');
		}
	};



	xhr.open("POST","reimbAdd", true); // goes to the register servlet! 
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);

}





function table(){
//	creates table variables by looping into a string array data type , converts  and formats as well 
	$.get( "viewTable", function( data ) {
		var dataSet=[];
		for(let i = 0 ; i < data.length;i++){
			dataSet[i]=[
			            data[i].submitted
			            ,typeConv(data[i].type)
			            ,String("$"+data[i].amount.toFixed(2))
			            ,statusConv(data[i].status)
			            ,data[i].resolved
			            ,data[i].desc];
		}



		let desc1=`<input type="text" id="desc" placeholder="REIMB reason (optional)">`;	
		let amount1='<input type="text" id="amount" placeholder="Riemb Amount">';
		let type1='<select id = type><option value=0>Lodging</option><option value=1>Travel</option><option value=2>Food</option><option value=3>Other</option></select>'
			let button='<button id="add">Add!</button>'
				dataSet[data.length]=[

				                      button
				                      ,type1
				                      ,amount1
				                      ,""
				                      ,""
				                      ,desc1];

		table1(dataSet);

	});
};

//didn't opt to use reimb log this time, manual conversion used here for status and type 
function statusConv(status){
	switch (status) {
	case 0:
		return("Pending");
		break;
	case 1:
		return("Approved");
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
	$('#example').DataTable( {
		data: dataSet,
		columns: [
		          { title: "Submitted" },
		          { title: "Type" },
		          { title: "Amount" },
		          { title: "Status" },
		          { title: "Resolved" },
		          { title: "Desc" }
		          ]
	} );
};

