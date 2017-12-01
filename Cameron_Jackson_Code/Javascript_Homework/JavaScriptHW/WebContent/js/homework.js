/**
 * 1. Fibonacci
 * Define function: fib(n)
 * Return the nth number in the fibonacci sequence
 */
function fib(n) {
	if (n<3) return 1;
	return fib(n-1)+fib(n-2);
}

document.getElementById("fib-input").addEventListener('click', function(e) {
	var input = document.getElementById("fib").value;
	input = Number.parseInt(input, 10);
	var out = fib(input);
	document.getElementById("fib-ans").innerHTML = out;
	document.getElementById("fib").value = "";
})

//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.
function bubbleSort(numArray) {
	var swapped;
	var greaterThan;
	if (typeof(numArray) != "object") 
		return null;
	
	for (i = 0; i < numArray.length; ++i) {
		if (typeof(numArray[i]) == "string")
			numArray[i] = numArray[i].trim();
		numArray[i] = Number.parseInt(numArray[i], 10);
	}
	do {
		swapped = false;
		for (x = 0; x < numArray.length-1; ++x) {
			if (numArray[x] > numArray[x+1]) {
				var temp = numArray[x];
				numArray[x] = numArray[x+1];
				numArray[x+1] = temp;
				swapped = true;
			}
		}
	} while (swapped == true);
	return numArray;
}

$('#bub-sort-input').on('click', function() {
	var arr = $('#bub-sort').val();
	var sArr = bubbleSort(arr.split(","));
	arrStr = sArr.join(", ");
	$('#bub-sort-ans').empty();
	$('#bub-sort-ans').append("Ans: " + arrStr);
	$('#bub-sort').val("");
});



//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.
function reverseStr(someStr) {
	var newStr = "";
	for (x = someStr.length-1; x >= 0; --x) {
		newStr = newStr.concat(someStr.charAt(x));
	}
	return newStr;
}

$('#rev-str-input').on('click', function() {
	var str = $('#rev-str').val();
	$('#rev-str-out').empty(); // clear out previous inputs
	$('#rev-str-out').append("Reversed: " + reverseStr(str));
	$('#rev-str').val("");
});


//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
	if (typeof(someNum) != "number") return null;
	if (someNum == 1) return someNum;
	return factorial(someNum-1) * someNum;
}

//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.
function mySubstring(someStr, length, offset) {
	if (typeof(someStr) != "string")
		alert("Parameter 'someStr' should be 'string' but is " + typeof(someStr));
	if (typeof(length) != "number")
		alert("Parameter 'length' should be 'number' but is " + typeof(length));
	if (typeof(offset) != "number")
		alert("Parameter 'offset' should be 'number' but is " + typeof(offset));
	if ((length < 0) || (offset < 0))
		alert("Can't accept negative values for length or offset");

	var sub = [];
	var temp = someStr.split("");
	var y = 0;
	for (x = offset; x < (offset+length); ++x) {
		sub[y] = temp[x];
		++y;
	}
	return sub.join("");
}

//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.
function isEven(someNum) {
	if (typeof(someNum) != "number")
		alert("Parameter 'length' should be 'number' but is " + typeof(someNum));

	if ((someNum & 1) == 1) return false;
	return true;
}

//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr) {
	if (typeof(someStr) != "string")
		return null;
	
	// depends on reverse string function
	var str = reverseStr(someStr);
	if (str === someStr)
		return true;
	
	return false;
}

//8. Shapes
//Define function: printShape(shape, height, character)
//shape is a String and is either "Square", "Triangle", "Diamond".
//height is a Number and is the height of the shape. Assume the number is odd.
//character is a String that represents the contents of the shape. Assume this String contains just one character.
//Use a switch statement to determine which shape was passed in.
//Use the console.log function to print the desired shape.
//Example for printShape("Square", 3, "%");
//%%%
//%%%
//%%%
//Example for printShape("Triangle", 3, "$");
//$
//$$
//$$$
//Example for printShape("Diamond", 5, "*");
//  *
// ***
//*****
// ***
//  *
function printShape(shape, height, character) {
	var square = function(height, character) {
		var row = "";
		for (x = 0; x < height; ++x) {
			row = row + character;
		}
		var shape = "";
		for (x = 0; x < height; ++x) {
			shape = shape + row + '\n';
		}
		console.log(shape);
	}
	
	var triangle = function(height, character) {
		var shape = "";
		for (x = 1; x <= height; ++x) {
			for (y = 1; y <= x; ++y)
				shape = shape + character;
			shape = shape + '\n';
		}
		console.log(shape);
	}
	
	var diamond = function(height, character) {
		var shape = "";
		var mid = (height+1)/2;
		for (y = 1; y < mid; ++y) {
			for (x = 1; x < mid; ++x)
				shape = shape + " ";
		}
		
		shape = shape + '\n';
	}
	switch(shape) {
	case "Square":
	case "Triange":
	case "Diamond":
	default:
		return null;
	}
}

//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.
function traverseObject(someObj) {
	
}

//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.
//
//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.
//
//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//	var john = new Person("John", 30);
//
//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//	var john = getPerson("John", 30);
// 
// 
// 
// 
// 
//-----------------------------------------------------------------------------------
//PART II
//
//Part II will focus on Javascript's ability to manipulate the DOM.
//Use the provided index.html
//Put your Javascript in the provided <script> element at the bottom of the page.
//Please put the question itself as a comment above each answer.
//
//NOTE: Part II will be done twice: once with Javascript and once with jQuery.
//	  They should be done separately.
//	  Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
//-----------------------------------------------------------------------------------
//
//1. USA
//Define function getUSA()
//Find the html element that contains "USA".
//Print that element's contents.
//  
//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.
//  
//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>
//  
//4. Hobbies
//Define function getHobbies()
//Find all checked options in the 'skills' select element.
//Print the value and the contents.
//  
//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.
//Print the element that has the attribute.
//
//6. Sum Event
//NOTE: Write unobtrusive Javascript
//Regarding these elements:
//	<input id="num1" class="nums" type="text"/>
//	<input id="num2" class="nums" type="text"/>
//	<h3>Sum: <span id="sum"></span></h3>
//
//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element
//
//7. Skills Event
//NOTE: Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//	"Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.
//
//8. Favorite Color Event
//NOTE: Write unobtrusive Javascript
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//	"So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
//
//9. Show/Hide Event
//NOTE: Write unobtrusive Javascript
//When user hovers over an employees name:
//	Hide the name if shown.
//	Show the name if hidden.
//
//10. Current Time
//Regarding this element:
//	<h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.
//
//11. Delay
//Regarding this element:
//	<p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.
//
//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).