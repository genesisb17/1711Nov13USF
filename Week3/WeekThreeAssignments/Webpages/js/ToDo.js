/**
 * 
 */

/*
 *  This function below can replace document the document.addeventlistener
 */
$("#add").on('click',function(){
	var temp = document.createElement("li");
	temp.setAttribute("class", "test");
	temp.innerHTML = $("#newItem").val();
	$("toDo").append(temp);
	$("newItem").val("");
	$('li').on("click",function(){
		$(this).remove();
	});
});

$("li#toDo").on('click',function(){
	var temp = document.createElement("li");
	temp.innerHTML = $("li#toDo").val();
	$("completed").append(temp);
	$("li#toDo").on("click", function(){
		$("li").remove();
	});
});