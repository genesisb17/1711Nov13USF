/**
 * 
 */

window.onload = function(){
	$('#add').on('click', add);
	$('#amount').blur(validAmount);
	$('#add').attr("disabled",true);
}

function validAmount(){
	var amount = $(`#amount`).val();
	console.log(amount);
	 if (isNaN(amount) || amount < 0) {
		 $(`#amountmessage`).html("only positive and real numbers are accepted");
		 $('#add').attr("disabled",true);
	 }else	{
		
		$(`#amountmessage`).html("");
		$('#add').attr("disabled",false);
	}
}




function add(){
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
	console.log(json);

	var xhr = new XMLHttpRequest();
	console.log(xhr.readyState);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("in xhr callback" + xhr.responseText);
			console.log("i tried, now crie");
		}
	};



	xhr.open("POST","reimbAdd", true); // goes to the register servlet! 
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);
	console.log("good luck m8 off to the servlet");

}
