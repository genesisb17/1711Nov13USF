/** 1. Fibonacci
* 		Define function: fib(n) 
* 		Return the nth number in the fibonacci sequence.
*/

function fib(num) {
	if(num < 2) { 
		return 1; 
	}
	
	else { 
		return fib(num - 1) + fib(num - 2) 
	}
}

function runFib() {
	var display = document.getElementById("fibDisplay");
	var num = document.getElementById("fibNum").value;
	display.innerHTML = fib(num);
}

document.getElementById("doFib").addEventListener("click", runFib);

/*---------------------------------------------------------------------------*/

/** 2. Bubble Sort
*		Define function: bubbleSort(numArray)
*		Use the bubble sort algorithm to sort the array.
*		Return the sorted array.
*/

function bubbleSort(numArray) {
	temp = 0;
		
	for(i = 0; i < numArray.length; i++) {
		
		for(j = 1; j < numArray.length; j++) {
			
			if(numArray[j-1] > numArray[j]) {
				
				temp = numArray[j-1];
				numArray[j-1] = numArray[j];
				numArray[j] = temp;
			}
		}
	}
	
	return numArray;
}

var unsortedArray = [];

function loadUnsortedArray() {
	var form = document.getElementById("element");
	var element = parseInt(document.getElementById("element").value);
	unsortedArray.push(element);
	form.value = '';
}

function runBubbleSort() {
	var display = document.getElementById("bubbleSortDisplay");
	
	display.innerHTML = bubbleSort(unsortedArray).join();
}

document.getElementById("insertIntoArray").addEventListener("click", loadUnsortedArray);
document.getElementById("doBubbleSort").addEventListener("click", runBubbleSort);
/*---------------------------------------------------------------------------*/

/** 3. Reverse String
*		Define function: reverseStr(someStr)
*		Reverse and return the String.
*/
function reverseStr(someStr) {
	var reversedStr = "";
	var arr = [];
	
	for(letter of someStr) {
		arr.push(letter);
	}
	
	arr.reverse();
	
	for(element of arr) {
		reversedStr = reversedStr.concat(element)
	}
	
	return reversedStr;
}

function runReverseStr() {
	var display = document.getElementById("reverseStrDisplay");
	var someStr = document.getElementById("reverseSomeStr").value;
	display.innerHTML = reverseStr(someStr);
}

document.getElementById("doReverseStr").addEventListener("click", runReverseStr);

/*---------------------------------------------------------------------------*/

/** 4. Factorial
*		Define function: factorial(someNum)
*		Use recursion to compute and return the factorial of someNum.
*/
function factorial(someNum) {
	if (someNum < 0) { 
		return 0; 
	}
	
	else if (someNum == 0 || someNum == 1) { 
		return 1; 
	}
	
	let result = factorial(someNum - 1) * someNum;
	return result;
}

function runFactorial() {
	var display = document.getElementById("factorialDisplay");
	var someNum = document.getElementById("someNum").value;
	display.innerHTML = factorial(someNum);
}

document.getElementById("doFactorial").addEventListener("click", runFactorial);

/*---------------------------------------------------------------------------*/

/** 5. Substring
*		Define function substring(someStr, length, offset)
*		Return the substring contained between offset and (offset + length) inclusively.
*		If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/
function substring(someStr, length, offset) {
	if (length < offset) {
		alert("Error: length value cannot be less than offset index value");
	}
	
	else if (length < 0 || offset < 0) {
		alert("Error: cannot accept negative values");
	}

	else if ((typeof(someStr) != "string") || (typeof(length) != "number") || (typeof(offset) != "number")) {
		alert("Error: unexpected argument type\n\nSyntax: substring(string, number, number)");
	}
	
	return someStr.slice(offset, length);
}

function runSubstring() {
	var display = document.getElementById("substringDisplay");
	var someStr = document.getElementById("substringSomeStr").value;
	var length = parseInt(document.getElementById("length").value);
	var offset = parseInt(document.getElementById("offset").value);
	display.innerHTML = substring(someStr, length, offset);
}

document.getElementById("doSubstring").addEventListener("click", runSubstring);

/*---------------------------------------------------------------------------*/

/** 6. Even Number
*		Define function: isEven(someNum)
*		Return true if even, false if odd.
*		Do not use % operator.
*/
function isEven(num) {
	if((Math.floor(num / 2) * 2) == num) {
		return true;
	}
	else {
		return false;
	}
}

function runIsEven() {
	var display = document.getElementById("isEvenDisplay");
	var num = document.getElementById("isEvenNum").value;
	display.innerHTML = isEven(num);
}

document.getElementById("doIsEven").addEventListener("click", runIsEven);

/*---------------------------------------------------------------------------*/

/** 7. Palindrome
*		Define function isPalindrome(someStr)
*		Return true if someStr is a palindrome, otherwise return false
*/

/*---------------------------------------------------------------------------*/

/** 8. Shapes
*		Define function: printShape(shape, height, character)
*			shape is a String and is either "Square", "Triangle", "Diamond".
*			height is a Number and is the height of the shape. Assume the number is odd.
*			character is a String that represents the contents of the shape. Assume this String contains just one character.
*
*		Use a switch statement to determine which shape was passed in.
*		Use the console.log function to print the desired shape.
*
*		Example for printShape("Square", 3, "%");
*		%%%
*		%%%
*		%%%
*
*		Example for printShape("Triangle", 3, "$");
*		$
*		$$
*		$$$
*
*		Example for printShape("Diamond", 5, "*");
*		 *
*		***
*	   *****
*		***
*		 *
*/

/*---------------------------------------------------------------------------*/

/** 9. Object literal
*		Define function traverseObject(someObj)
*		Print every property and it's value.
*/

/*---------------------------------------------------------------------------*/

/** 10. Delete Element
*			Define function deleteElement(someArr)
*			Print length
*			Delete the third element in the array.
*			Print length
*			The lengths should be the same.
*/

/*---------------------------------------------------------------------------*/

/** 11. Splice Element
*			Define function spliceElement(someArr)
*			Print length
*			Splice the third element in the array.
*			Print length
*			The lengths should be one less than the original length.
*/

/*---------------------------------------------------------------------------*/

/** 12. Defining an object using a constructor
*			Define a function Person(name, age)
*			The following line should set a Person object to the variable john:
*			
*			var john = new Person("John", 30);
*/

/*---------------------------------------------------------------------------*/

/** 13. Defining an object using an object literal
*			Define function getPerson(name, age)
*			The following line should set a Person object to the variable john:
*			
*			var john = getPerson("John", 30);
*/ 
 
 
 
 
/*---------------------------------------------------------------------------*/

/** PART II
*
*		Part II will focus on Javascript's ability to manipulate the DOM.
*		
*		Use the provided index.html
*
*		Put your Javascript in the provided <script> element at the bottom of the page.
*
*		Please put the question itself as a comment above each answer.
*
*		NOTE: Part II will be done twice: once with Javascript and once with jQuery.
*	 		  They should be done separately.
*	  		  Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
*/	 
/*---------------------------------------------------------------------------*/

/** 1. USA
*		Define function getUSA()
*		Find the html element that contains "USA".
*		Print that element's contents.
*/ 
 
/* 2. Sales
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
On each node, call func(node). */