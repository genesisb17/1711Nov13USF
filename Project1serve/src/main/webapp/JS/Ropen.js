/**
 * 
 */
window.onload = function()
{
	console.log("test10")
	$('#message').hide();
	$('#ropen').on('click',ropen);
	
}
function ropen()
{	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function()
	{
		if(xhr.readyState == 4 && xhr.status==200)
		{
			 console.log("sucess");
		}
	};
	xhr.open("POST","Rtype", true);
	console.log(xhr.readyState);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	console.log("AFTER HEADER " + xhr.readyState);
	xhr.send(json);	
}