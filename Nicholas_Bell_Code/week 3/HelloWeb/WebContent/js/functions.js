// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.

function fib(n){
	console.log(n)
	if (n<=1) return n;
	else return fib(n-1) + fib(n-2);
}

function runFib(){
	//alert("HELLO!");
	var display = document.getElementById("fibDisplay");
	var n = document.getElementById("fib").value;
	display.innerHTML = fib(n);
}

document.getElementById("doFib").addEventListener("click", runFib);




//Some helper functions
function swap(arr, i1, i2){
	let tmp = arr[i1];
	arr[i1] = arr[i2];
	arr[i2] = tmp;
}

function arrayPrint(arr){
	let print = "";
	let length = arr.length;
	for (let i = 0 ; i<length ; i++){
		print+=" " + arr[i];
	}
	return print;
}

/*2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.*/

bubblearr = [1,0,5,6,3,2,3,7,9,8,4];
document.getElementById("bub_array_unsort").innerHTML = arrayPrint(bubblearr);

//this implementation works


// function BubbleSort(){

// 	var newarr = bubblearr;
// 	let length = newarr.length;
// 	let tracker = 1;
// 	let swapflag = false;
	
// 	do{
// 		swapflag = false;
// 		tracker = 1;
// 		while(tracker<length){
// 			if(newarr[tracker] < newarr[tracker-1]){
// 				swap(newarr, tracker, tracker-1);
// 				swapflag = true;
// 			}
// 			tracker++
// 		}
// 	}while(swapflag)
	
// 	return newarr
// }

// function runBubble(){
// 	let display = document.getElementById("bub_array_sort");
// 	display.innerHTML = arrayPrint(BubbleSort());
// }


//this implementation does not work - FIXED
//NOTES didn't work because we declared bubblearr after calling it.

function BubbleSort(somearr){
	let length = somearr.length;
	let tracker = 1;
	let swapflag = false;
	
	do{
		swapflag = false;
		tracker = 1;
		while(tracker<length){
			if(somearr[tracker] < somearr[tracker-1]){
				swap(somearr, tracker, tracker-1);
				swapflag = true;
			}
			tracker++
		}
	}while(swapflag)
	
	return somearr;
} 

function runBubble(){
	let display = document.getElementById("bub_array_sort");
	display.innerHTML = arrayPrint(BubbleSort(bubblearr));
} 

// function runBubble(){
// let display = document.getElementById("bub_array_sort");
// display.appendChild(arrayPrint(BubbleSort(bubblearr)));
// } 
// When moving the tag to the paragraph that contains "the new array:" in the inner html, i try to append to that tag.
// doesn't work. why?

document.getElementById("doBub").addEventListener("click", runBubble);

/*3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.*/
start_string = "ABCDEFG";
document.getElementById("str_start").innerHTML = start_string;

function reverseStr(someStr){
	let anArr = someStr.split('');
	let start = 0;
	let end = anArr.length - 1;
	for( ; start<end ; start++, end--){
		swap(anArr, start, end);
	}
	someStr = anArr.join('');
	return someStr;
}

function runReverse(){
	let display = document.getElementById("str_rev");
	display.innerHTML = reverseStr(start_string);
}

document.getElementById("flipstr").addEventListener("click", runReverse);

/*4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.*/

function factorial(n){
	console.log("in factorial");
	//PARSE EVERYTHING APPARENTLY
	let i = parseInt(n);
	console.log(i);
	if(typeof(i)!="number"|| i==NaN || i==Infinity){
		console.log("in type checker")
		return 0;
	}
	else if (i===1){
		return 1;
	}else if(i <= 0){
		return 0;
	}
	else{
		return i * factorial(i-1);
	}
}

function doFact(){
	let display = document.getElementById("factans");
	let n = document.getElementById("fact").value;
	let i = factorial(n);
	if(i){
		display.innerHTML = i;
	}
	else{
		display.innerHTML = "Please enter valid number";
	}
}
 document.getElementById("factbut").addEventListener("click", doFact);



/*document.getElementById("outer").addEventListener("click", function(){
	alert("IN OUTER");}, true)

document.getElementById("middle").addEventListener("click", function(){
	alert("IN MIDDLE");}, false)

document.getElementById("inner").addEventListener("click", function(){
	alert("IN INNER");}, true)*/	



/*
5. Substring

4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.

5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.

6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.

7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false

8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
Example for printShape("Square", 3, "%");
%%%
%%%
%%%
Example for printShape("Triangle", 3, "$");
$
$$
$$$
Example for printShape("Diamond", 5, "*");
  *
 ***
*****
 ***
  *

9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.

10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.

11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.

12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);

13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
 
 
 
 
 
-----------------------------------------------------------------------------------
PART II

Part II will focus on Javascript's ability to manipulate the DOM.
Use the provided index.html
Put your Javascript in the provided <script> element at the bottom of the page.
Please put the question itself as a comment above each answer.

NOTE: Part II will be done twice: once with Javascript and once with jQuery.
	  They should be done separately.
	  Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
-----------------------------------------------------------------------------------

1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
  
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
  
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
  
4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
  
5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.

6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
	<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
	<h3>Sum: <span id="sum"></span></h3>

Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element

7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
	"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.

8. Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
	"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
	Hide the name if shown.
	Show the name if hidden.

10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.

11. Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.

12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. Use recursion.
On each node, call func(node).



 */

