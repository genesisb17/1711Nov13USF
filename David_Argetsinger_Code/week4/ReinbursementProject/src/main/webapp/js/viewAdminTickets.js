
window.onload = function(){
	$('#update').attr("disabled",true);
	id=[]; // used to check for valid id's
	table();

}
 

$('document').ready(function(){
	$('#example').click(function(event) {
		if(event.originalEvent.path[1].className=="clickables"){
			{
				if(event.originalEvent.path[0].id=="accept")
				update(event.originalEvent.path[1].id,1);
				if(event.originalEvent.path[0].id=="deny")
				update(event.originalEvent.path[1].id,2);
			}
		}

	});

});





function update(id,typ){
	var reimburse = {
			id: id,
			amount: null,
			submitted: null,
			resolved: null, 
			desc: null, 
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
			window.location.replace('admin.html');

		}
	};

	xhr.open("POST","reeimbUpd", true);  
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(json);


}

function table(){
	$.get( "viewAdminTable", function( data ) {
		let resol="";
		let res="";
		var dataSet=[];
		for(let i = 0 ; i < data.length;i++){
			if(data[i].resolver==null)
			{
				res=`<span class="clickables" id="${ data[i].id }"><button id="accept" type="button" class="btn btn-primary"	 style="background-color: #86C4B8">accept!</button><button style="background-color: #BA967Be" id="deny" type="button" class="btn btn-primary">deny!</button></span>`;	
			}else{
				res=data[i].resolver;
			}
			if(data[i].resolver==null)
			{
				resol=String("</span>")
			}else{
				resol=String(data[i].resolved+"</span>")
			}


			id.push(data[i].id)
			dataSet[i]=[
			            i
			            ,data[i].fname
			            ,data[i].lname
			            ,data[i].rstatus
			            ,String("$"+data[i].amount.toFixed(2))
			            ,data[i].desc
			            ,data[i].rtype
			            ,data[i].date
			            ,res
			            ,resol
			            ];
		}
		table1(dataSet);
	});

};

function table1(dataSet){
	$('#example').DataTable( {
		data: dataSet,
		columns: [

		          { title: "Request#" },
		          { title: "FirstName" },
		          { title: "LastName" },
		          { title: "Reuqest Status#" },
		          { title: "Amount" },
		          { title: "Desc" },
		          { title: "Type" },
		          { title: "date" },
		          { title: "Resolver" },
		          { title: "Resolved" }
		          ]

	}
	);
};