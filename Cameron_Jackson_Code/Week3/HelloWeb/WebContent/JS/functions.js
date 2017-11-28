/**
 * 1. Fibonacci
 * Define function: fib(n)
 * Return the nth number in the fibonacci sequence
 */
function fib(n) {
	if (n<1) return 1;
	return fib(n-1)+fib(n-2);
}


//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.
function bubbleSort(numArray) {
	var swapped;
	if (typeof(numArray) != "object") 
		return null;
	
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

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.
function reverseStr(someStr) {
	if (typeof(someStr) != "string") return null;
	var x = 0;
	var temp;
	var charArr = someStr.split("");
	var newArr = []
	for (y = someStr.length; y > 0; --y) {
		newArr[y] = charArr[x];
		++x;
	}
	return newArr.join("");
}

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