/*
 * previously app.js
 */
$(document).on("click", "#hello", function() 
{  // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
    $.get("viewr", function(responseJson) 
    {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...

    });
});

window.onload = function()
{
	console.log("test1")
	$('#message').hide();
	$('#hello').on('click',reimb);	
}

function reimb()
{
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function()
	{
		if(xhr.readyState == 4 && xhr.status==200)
		{
		}
	};
	xhr.open("POST","viewr", true);
	console.log(xhr.readyState);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	console.log("AFTER HEADER " + xhr.readyState);
	xhr.send(json);	
}